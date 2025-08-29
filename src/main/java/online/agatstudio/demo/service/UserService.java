package online.agatstudio.demo.service;

import lombok.AllArgsConstructor;
import online.agatstudio.demo.exception.UserNotFoundException;
import online.agatstudio.demo.model.User;
import online.agatstudio.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void add(User user) {
        userRepository.add(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }
    public void remove(long id) {
        userRepository.remove(id);
    }

    public User getById(long id) {
        User user = userRepository.getById(id);
        if (user == null) {
            throw new UserNotFoundException("User with id %d not found".formatted(id));
        }
        return user;
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }
}
