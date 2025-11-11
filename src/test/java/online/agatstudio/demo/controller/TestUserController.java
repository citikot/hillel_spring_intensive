package online.agatstudio.demo.controller;

import online.agatstudio.demo.config.TestConfig;
import online.agatstudio.demo.model.User;
import online.agatstudio.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(TestConfig.class)
class TestUserController {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    void getAllUsersTest() throws Exception {
        when(userService.getAll()).thenReturn(List.of(new User(1L, "BOB")));
        mockMvc.perform(get("/users/all"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"BOB\"}]"));
    }

}
