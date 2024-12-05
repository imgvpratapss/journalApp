package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
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

class JournalControllerTest {
    @Mock
    JournalEntryService entryService;
    @InjectMocks
    JournalController journalController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllJournalEntriesOfUser() {
        when(entryService.findAllEntries(anyString())).thenReturn(List.of(Map.of("String", "String")));

        List<Map> result = journalController.getAllJournalEntriesOfUser();
        Assertions.assertEquals(List.of(Map.of("String", "String")), result);
    }

    @Test
    void testGetById() {
        when(entryService.user(anyString())).thenReturn(null);
        when(entryService.findById(any())).thenReturn(null);

        ResponseEntity<Object> result = journalController.getById(null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCreateEntry() {
        when(entryService.saveJournalEntry(any(), anyString())).thenReturn(Map.of(null, null));

        Map<ObjectId, JournalEntry> result = journalController.createEntry(null);
        Assertions.assertEquals(Map.of(null, null), result);
    }

    @Test
    void testUpdateEntry() {
        when(entryService.user(anyString())).thenReturn(null);
        when(entryService.saveJournalEntry(any())).thenReturn(Map.of(null, null));
        when(entryService.findById(any())).thenReturn(null);

        Map<ObjectId, JournalEntry> result = journalController.updateEntry(null, null);
        Assertions.assertEquals(Map.of(null, null), result);
    }

    @Test
    void testDeleteEntry() {
        when(entryService.deleteEntryById(any(), anyString())).thenReturn(Boolean.TRUE);

        ResponseEntity<?> result = journalController.deleteEntry(null);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
