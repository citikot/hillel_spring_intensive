package online.agatstudio.demo.repository;

import lombok.AllArgsConstructor;
import online.agatstudio.demo.exception.UserNotFoundException;
import online.agatstudio.demo.model.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@AllArgsConstructor
@ConditionalOnProperty(name = "data.store.type", havingValue = "JPA")
public class UserRepositoryJpaFacade implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    public void create(User user) {
        userRepositoryJpa.save(user);
    }

    @Override
    public void update(User user) {
        userRepositoryJpa.save(user);
    }

    @Override
    public void remove(long id) {
        userRepositoryJpa.deleteById(id);
    }

    @Override
    public User getById(long id) {
        return userRepositoryJpa.findById(id).orElseThrow(() ->
                new UserNotFoundException("User with id %d not found".formatted(id)));
    }

    @Override
    public Collection<User> getAll() {
        return (Collection<User>) userRepositoryJpa.findAll();
    }
}
