package online.agatstudio.demo.service;

import lombok.AllArgsConstructor;
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
        return userRepository.getById(id);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }
}
