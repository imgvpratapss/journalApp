package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

class UserControllerTest {
    @Mock
    UserService userService;
    @InjectMocks
    UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        when(userService.users()).thenReturn(List.of(Map.of("String", "String")));

        List<Map> result = userController.getAllUsers();
        Assertions.assertEquals(List.of(Map.of("String", "String")), result);
    }

    @Test
    void testGetUserById() {
        when(userService.findById(any())).thenReturn(null);

        ResponseEntity<Object> result = userController.getUserById(null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCreateUser() {
        when(userService.saveUser(any())).thenReturn(Map.of(null, null));

        userController.createUser(null);
    }

    @Test
    void testUpdateUser() {
        when(userService.saveUser(any())).thenReturn(Map.of(null, null));
        when(userService.findByUserName(anyString())).thenReturn(null);

        Map<ObjectId, User> result = userController.updateUser(null);
        Assertions.assertEquals(Map.of(null, null), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
