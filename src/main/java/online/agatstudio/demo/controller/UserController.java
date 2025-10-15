package online.agatstudio.demo.controller;

import lombok.AllArgsConstructor;
import online.agatstudio.demo.model.User;
import online.agatstudio.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public User getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @GetMapping("/all")
    public Collection<User> getAll() throws InterruptedException {
        return userService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.add(user);
    }
}
