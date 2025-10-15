package online.agatstudio.demo.repository;

import online.agatstudio.demo.model.User;

import java.util.Collection;

public interface UserRepository {

    void create(User user);

    void update(User user);

    void remove(long id);

    User getById(long id);

    Collection<User> getAll();
}
