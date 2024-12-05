package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.service.UserService;
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

class AdminControllerTest {
    @Mock
    UserService userService;
    @InjectMocks
    AdminController adminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(userService.users()).thenReturn(List.of(Map.of("String", "String")));

        ResponseEntity<?> result = adminController.getAll();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCreateAdmin() {
        when(userService.saveNewUser(any())).thenReturn(Map.of(null, null));

        ResponseEntity<?> result = adminController.createAdmin(null);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
