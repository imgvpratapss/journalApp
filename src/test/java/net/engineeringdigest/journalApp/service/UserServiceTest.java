package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.*;
@SpringBootTest
class UserServiceTest {
    @Mock
    UserRepo userRepo;
    @Mock
    PasswordEncoder passwordEncoder;
    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveNewUser() {
        Map<ObjectId, User> result = userService.saveNewUser(null);
        Assertions.assertEquals(Map.of(null, null), result);
    }

    @Test
    void testSaveUser() {
        Map<ObjectId, User> result = userService.saveUser(null);
        Assertions.assertEquals(Map.of(null, null), result);
    }

    @Test
    void testUsers() {
        List<Map> result = userService.users();
        Assertions.assertNotNull( result);
        System.out.println(result);
    }

    @Test
    void testFindById() {
        Optional<User> result = userService.findById(null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteUserById() {
        Boolean result = userService.deleteUserById(null);
        Assertions.assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testFindByUserName() {
        when(userRepo.findByUserName(anyString())).thenReturn(null);

        Optional<User> result = userService.findByUserName("shiva");
        Assertions.assertNotNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
