package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.*;

class JournalEntryServiceTest {
    @Mock
    JournalEntryRepo entryRepo;
    @Mock
    UserService userService;
    @InjectMocks
    JournalEntryService journalEntryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUser() {
        when(userService.findByUserName(anyString())).thenReturn(null);

        User result = journalEntryService.user("username");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSaveJournalEntry() {
        when(userService.saveUser(any())).thenReturn(Map.of(null, null));
        when(userService.findByUserName(anyString())).thenReturn(null);

        Map<ObjectId, JournalEntry> result = journalEntryService.saveJournalEntry(new JournalEntry(null, "title", "content", null), "username");
        Assertions.assertEquals(Map.of(null, new JournalEntry(null, "title", "content", null)), result);
    }

    @Test
    void testSaveJournalEntry2() {
        Map<ObjectId, JournalEntry> result = journalEntryService.saveJournalEntry(new JournalEntry(null, "title", "content", null));
        Assertions.assertEquals(Map.of(null, new JournalEntry(null, "title", "content", null)), result);
    }

    @Test
    void testFindAllEntries() {
        when(userService.findByUserName(anyString())).thenReturn(null);

        List<Map> result = journalEntryService.findAllEntries("username");
        Assertions.assertEquals(List.of(Map.of("String", "String")), result);
    }

    @Test
    void testFindById() {
        Optional<JournalEntry> result = journalEntryService.findById(null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteEntryById() {
        when(userService.saveUser(any())).thenReturn(Map.of(null, null));
        when(userService.findByUserName(anyString())).thenReturn(null);

        Boolean result = journalEntryService.deleteEntryById(null, "username");
        Assertions.assertEquals(Boolean.TRUE, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
