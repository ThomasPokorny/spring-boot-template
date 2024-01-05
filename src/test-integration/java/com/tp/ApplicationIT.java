package com.tp;

import com.tp.util.TestDatabaseCleaner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {SpringBootTemplate.class})
@ActiveProfiles("integration-test")
@AutoConfigureMockMvc
public class ApplicationIT {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private TestDatabaseCleaner databaseCleaner;

    @AfterEach
    void cleanDatabaseAndStorage() {
        databaseCleaner.clean();
    }

    @Test
    void contextLoads() {
        assertThat(applicationContext.getId()).isNotEmpty();
    }
}
