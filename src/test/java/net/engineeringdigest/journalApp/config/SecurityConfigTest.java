package net.engineeringdigest.journalApp.config;

import net.engineeringdigest.journalApp.service.CustomUserDetailsServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.accept.ContentNegotiationStrategy;

import static org.mockito.Mockito.*;

class SecurityConfigTest {
    @Mock
    CustomUserDetailsServiceImpl userDetailsService;
    @Mock
    Logger log;
    @Mock
    Log logger;
    @Mock
    ApplicationContext context;
    @Mock
    ContentNegotiationStrategy contentNegotiationStrategy;
    @Mock
    ObjectPostProcessor<Object> objectPostProcessor;
    @Mock
    AuthenticationConfiguration authenticationConfiguration;
    @Mock
    AuthenticationManagerBuilder authenticationBuilder;
    @Mock
    AuthenticationManagerBuilder localConfigureAuthenticationBldr;
    @Mock
    AuthenticationManager authenticationManager;
    @Mock
    AuthenticationTrustResolver trustResolver;
    //Field http of type HttpSecurity - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    SecurityConfig securityConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConfigure() throws Exception {
        securityConfig.configure((AuthenticationManagerBuilder) null);
    }

    @Test
    void testConfigure2() throws Exception {
        securityConfig.configure((AuthenticationManagerBuilder) null);
    }

    @Test
    void testPasswordEncoder() {
        PasswordEncoder result = securityConfig.passwordEncoder();
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
