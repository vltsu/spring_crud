package jettyapp.mvc;

import jettyapp.mvc.controller.UserController;
import static java.util.Arrays.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

import jettyapp.mvc.service.UserService;
import jettyapp.mvc.model.User;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")

public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    protected WebApplicationContext wac;

    @Test
    public void shouldDisplayUsers() {

        List <User> expectedUsers = asList(new User(), new User(), new User());

        UserService userService = mock(UserService.class);

        when(userService.getAllUsers()).thenReturn(expectedUsers);

        ReflectionTestUtils.setField(userController, "userService", userService);

        ExtendedModelMap model = new ExtendedModelMap();
        String viewName = userController.index(model);

        assertEquals("users/index", viewName);
        assertSame(expectedUsers, model.get("users"));
    }
}