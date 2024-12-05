package net.engineeringdigest.journalApp.mytest.service;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Optional;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("dev")
@Slf4j
public class UserDetailsServiceTest {

   // private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceTest.class);
    // or user @slf4j
    @Autowired
    private UserDetailsService userDetailsService;

    @MockBean
    private UserRepo userRepo;


    private String username = "vijay";
    @Test
    public void checkUserName(){
        try {
            var user=  loadUserByUsername();
            System.out.println("Hi \n"+user);
            if(user.getUsername()!=username)
                throw new  UsernameNotFoundException("User not found");
        } catch (UsernameNotFoundException e) {

            log.error("Error occurred  for : {}",username,e );
            log.debug("debug");
            log.trace("trace");
            throw new RuntimeException(e);
//        LOGGER.info("info");
//        LOGGER.warn("warning");
//        LOGGER.debug("debug");
//        LOGGER.trace("trace");
        }

    }

    @ValueSource(strings={"vijay"})
    @Test
    public UserDetails loadUserByUsername() throws UsernameNotFoundException {
        username = this.username;
        when(userRepo.findByUserName(ArgumentMatchers.anyString())).thenReturn(Optional.ofNullable(User.builder().userName("shiva").password("abc").roles(Arrays.asList("USER")).build()));
        var user=  userDetailsService.loadUserByUsername(username);
        Assertions.assertNotNull(user);
        return user;
    }
}
