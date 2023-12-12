package com.project.appz;

import com.project.appz.service.notification.EventListener;
import com.project.appz.service.notification.impl.EventManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EventManagerTest {
    private EventManager eventManager;
    private EventListener mockListener;
    private LocalDate date;

    @BeforeEach
    void setUp() {
        eventManager = new EventManager();
        mockListener = Mockito.mock(EventListener.class);
        date = LocalDate.now();
    }

    @Test
    void testSubscribe_NewDate() {
        eventManager.subscribe(date, mockListener);
        eventManager.notify(date);
        verify(mockListener, times(1)).update();
    }

    @Test
    void testSubscribe_ExistingDate() {
        eventManager.subscribe(date, mockListener);
        EventListener anotherMockListener = Mockito.mock(EventListener.class);
        eventManager.subscribe(date, anotherMockListener);
        eventManager.notify(date);
        verify(mockListener, times(1)).update();
        verify(anotherMockListener, times(1)).update();
    }

    @Test
    void testUnsubscribe() {
        eventManager.subscribe(date, mockListener);
        eventManager.unsubscribe(date, mockListener.getListenerId());
        eventManager.notify(date);
        verify(mockListener, times(0)).update();
    }

    @Test
    void testNotify_NoListeners() {
        eventManager.notify(date); // Should not throw any exceptions
    }
}

