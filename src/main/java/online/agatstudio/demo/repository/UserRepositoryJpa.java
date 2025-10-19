package online.agatstudio.demo.repository;

import online.agatstudio.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryJpa extends CrudRepository<User, Long> {
}
