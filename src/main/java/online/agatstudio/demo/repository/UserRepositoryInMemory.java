package online.agatstudio.demo.repository;

import online.agatstudio.demo.model.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@ConditionalOnProperty(name = "data.store.type", havingValue = "MEMORY")
public class UserRepositoryInMemory implements UserRepository {

    private static final Map<Long, User> users = new HashMap<>();

    public void create(User user) {
        users.put(user.getId(), user);
    }

    public void update(User user) {
        users.computeIfPresent(user.getId(), (k, v) -> user);
    }

    public void remove(long id) {
        users.remove(id);
    }

    public User getById(long id) {
        return users.get(id);
    }

    public Collection<User> getAll() {
        return users.values();
    }
}
