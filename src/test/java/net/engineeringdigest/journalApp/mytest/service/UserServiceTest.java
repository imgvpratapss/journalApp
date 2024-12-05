package net.engineeringdigest.journalApp.mytest.service;

import lombok.NonNull;
import lombok.var;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    private   String before_value ;
    private  String after_value;
    @Autowired
    private UserService userService;

    @BeforeEach
    void setUpBefore(){
        before_value="Hi this is value before each test case";
    }
   // @BeforeAll
    void setUpBeforeAll(){
        before_value="run before  all test cases /n "+before_value;
    }
    @AfterEach
    void setUpAfterEach(){
        after_value ="Hi this is value after each test case ";
    }
  //  @AfterAll
    void setUpAfterAll(){
        before_value="run after  all test cases /n "+before_value;
    }

    @Test
    //@Disabled
    public void testAdd(){
        System.out.println(before_value);
        assertEquals(4,2+2);
    }
    @Test
    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "vijay",
            "shiva",
            "SHIVA333",
            "11VIJAY"
    })
    public void findByUserName(String username){
        System.out.println(before_value);
        var tuser = userService.findByUserName(username);
        assertNotNull(tuser);
        assertTrue(!tuser.get().getJournalEntries().isEmpty(),"failed for : ");
    }

    @Test
    @ParameterizedTest
    @ArgumentsSource(net.engineeringdigest.journalApp.custom.UserArgumentProvider.class)
    public void saveUser(User user){
        System.out.println(before_value);
        var suser = userService.saveUser(user);
        assertNotNull(suser);
        assertTrue(!suser.entrySet().stream().findFirst().get().getValue().getPassword().isEmpty(),"failed for : "+suser);
    }

    @ParameterizedTest
    @CsvSource({
            "2,3,4",
            "4,5,8",
            "7,2,9"
    })
    public void test(int x , int y, int expected){
        System.out.println(before_value);
        assertEquals(expected,x+y);

    }
}
