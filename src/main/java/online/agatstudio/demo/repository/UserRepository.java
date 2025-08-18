package online.agatstudio.demo.repository;

import online.agatstudio.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private static final Map<Long, User> users = new HashMap<>();

    public void add(User user) {
        users.put(user.id(), user);
    }

    public User update(User user) {
        return users.computeIfPresent(user.id(), (k, v) -> user);
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
