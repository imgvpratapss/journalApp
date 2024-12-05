package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

class JournalEntryControllerTest {
    @Mock
    Map<Long, JournalEntry> journalEntries;
    @InjectMocks
    JournalEntryController journalEntryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<JournalEntry> result = journalEntryController.getAll();
        Assertions.assertEquals(List.of(new JournalEntry(null, "title", "content", null)), result);
    }

    @Test
    void testGetById() {
        JournalEntry result = journalEntryController.getById(Long.valueOf(1));
        Assertions.assertEquals(new JournalEntry(null, "title", "content", null), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
