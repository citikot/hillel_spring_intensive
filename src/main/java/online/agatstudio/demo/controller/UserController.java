package online.agatstudio.demo.controller;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import online.agatstudio.demo.model.User;
import online.agatstudio.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @PostMapping("/update")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @PostMapping("/remove/{id}")
    public void remove(@PathVariable long id) {
        userService.remove(id);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable long id) {return userService.getById(id);}

    @GetMapping("/all")
    @Timed(value = "endpoint.users.all", description = "Time spent on endpoint /users/all")
    public Collection<User> getAll() throws InterruptedException {return userService.getAll();}

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.add(user);
    }
}
