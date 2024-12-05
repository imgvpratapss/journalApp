package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;

class CustomUserDetailsServiceImplTest {
    @Mock
    UserRepo userRepo;
    @InjectMocks
    CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadUserByUsername() {
        when(userRepo.findByUserName(anyString())).thenReturn(Optional.ofNullable(User.builder().userName("shiva").password("abc").roles(Arrays.asList("USER")).build()));

        UserDetails result = customUserDetailsServiceImpl.loadUserByUsername("shiva");
        Assertions.assertEquals("shiva", result.getUsername());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
