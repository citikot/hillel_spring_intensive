package online.agatstudio.demo.repository;

import lombok.AllArgsConstructor;
import online.agatstudio.demo.exception.UserNotFoundException;
import online.agatstudio.demo.model.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@AllArgsConstructor
@ConditionalOnProperty(name = "data.store.type", havingValue = "JDBC")
public class UserRepositoryJDBC implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    public void create(User user) {
        String sql = "INSERT INTO users (name) VALUES (?)";
        jdbcTemplate.update(sql, user.getName());
    }

    public void update(User user) {
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getId());
    }

    public void remove(long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public User getById(long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("name")),
                    id
            );
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            throw new UserNotFoundException("User with id %d not found".formatted(id));
        }
    }


    public Collection<User> getAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("name"))
        );

    }
}
