package online.agatstudio.demo;

import online.agatstudio.demo.model.User;
import online.agatstudio.demo.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntegrationTest {

    @Autowired
    private UserService userService;

    @BeforeAll
    void setUp() {
        User user = new User();
        user.setName("BOB");
        userService.add(user);
    }

    @Test
    void getAllUsersTest() {
        assertEquals(1, userService.getAll().size());
    }

    @AfterAll
    void tearDown() {
        User user = userService.getAll().stream().findFirst().orElseThrow();
        userService.remove(user.getId());
    }

}
