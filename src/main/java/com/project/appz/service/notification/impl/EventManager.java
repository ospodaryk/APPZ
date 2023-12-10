package com.project.appz.service.notification.impl;

import com.project.appz.service.notification.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventManager {
    private Map<LocalDate, List<com.project.appz.service.notification.EventListener>> listeners = new HashMap<>();

    public void subscribe(LocalDate date, com.project.appz.service.notification.EventListener listener) {
        if (!listeners.containsKey(date)) {
            listeners.put(date, new ArrayList<>());
        }
        listeners.get(date).add(listener);
    }

    public void unsubscribe(LocalDate date, Long pollAssignmentId) {
        if (listeners.containsKey(date)) {
            listeners.get(date).removeIf((e) -> e.getListenerId() == pollAssignmentId);
        }
    }

    public void notify(LocalDate date) {
        if (listeners.containsKey(date)) {
            for (EventListener listener : listeners.get(date)) {
                listener.update();
            }
        }
    }
}