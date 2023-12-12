package com.project.appz;
import com.project.appz.utils.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.PrintStream;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class LoggerTest {

    @Mock
    private PrintStream mockPrintStream;

    private Logger logger;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        logger = Logger.getInstance(mockPrintStream);
    }

    @Test
    void testLog() {
        String method = "testMethod";
        logger.log(method);
    }

    @Test
    void testDebug() {
        String method = "testMethod";
        String message = "Debug message";
        logger.debug(method, message);
    }

    @Test
    void testError() {
        String method = "testMethod";
        String message = "Error message";
        logger.error(method, message);
    }

    @Test
    void testWarn() {
        String method = "testMethod";
        String message = "Warning message";
        logger.warn(method, message);
    }
}
