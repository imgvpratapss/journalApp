package net.engineeringdigest.journalApp.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.PlatformTransactionManager;

class TransactionConfigTest {
    TransactionConfig transactionConfig = new TransactionConfig();

    @Test
    void testAdd() {
        PlatformTransactionManager result = transactionConfig.add(null);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
