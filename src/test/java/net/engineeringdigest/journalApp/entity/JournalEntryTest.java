package net.engineeringdigest.journalApp.entity;

import net.engineeringdigest.journalApp.entity.excception.CustomExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class JournalEntryTest {
    //Field id of type ObjectId - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    CustomExceptionMessage message;
    @InjectMocks
    JournalEntry journalEntry;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSetId() {
        journalEntry.setId(null);
    }

    @Test
    void testSetTitle() {
        journalEntry.setTitle("title");
    }

    @Test
    void testSetContent() {
        journalEntry.setContent("content");
    }

    @Test
    void testSetMessage() {
        journalEntry.setMessage(null);
    }

    @Test
    void testBuilder() {
        JournalEntry.JournalEntryBuilder result = JournalEntry.builder();
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
