package net.engineeringdigest.journalApp.entity;

import net.engineeringdigest.journalApp.entity.excception.CustomExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class UserTest {
    //Field id of type ObjectId - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    ArrayList<JournalEntry> journalEntries;
    @Mock
    CustomExceptionMessage message;
    @Mock
    List<String> roles;
    @InjectMocks
    User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSetId() {
        user.setId(null);
    }

    @Test
    void testSetUserName() {
        user.setUserName("userName");
    }

    @Test
    void testSetPassword() {
        user.setPassword("password");
    }

    @Test
    void testSetEmail() {
        user.setEmail("email");
    }

    @Test
    void testSetJournalEntries() {
        user.setJournalEntries(new ArrayList<>(List.of(new JournalEntry(null, "title", "content", null))));
    }

    @Test
    void testSetMessage() {
        user.setMessage(null);
    }

    @Test
    void testSetRoles() {
        user.setRoles(List.of("String"));
    }

    @Test
    void testEquals() {
        boolean result = user.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = user.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = user.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = user.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testBuilder() {
        User.UserBuilder result = User.builder();
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
