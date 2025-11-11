package online.agatstudio.demo.service;

import online.agatstudio.demo.model.User;
import online.agatstudio.demo.repository.UserRepositoryJpaFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class TestUserService {

    @Autowired
    private UserService userService;

    @MockitoBean
    private UserRepositoryJpaFacade userRepositoryJpaFacade;

    @Test
    void getAllUsersTest() {
        when(userRepositoryJpaFacade.getAll()).thenReturn(List.of(new User(1L, "BOB")));
        assertEquals(1, userService.getAll().size());
    }

}
