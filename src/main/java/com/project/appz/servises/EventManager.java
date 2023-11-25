package com.project.appz.servises;

import com.project.appz.entities.Notification;
import com.project.appz.interfaces.INotificationService;

import java.util.*;

public class EventManager {
    private Map<Date, List<EventListener>> listeners = new HashMap<>();

    public void subscribe(Date date, EventListener listener) {
        if (!listeners.containsKey(date)) {
            listeners.put(date, new ArrayList<>());
        }
        listeners.get(date).add(listener);
    }

    public void unsubscribe(Date date, Long notificationId) {
        if (listeners.containsKey(date)) {
            listeners.get(date).removeIf((e) -> e.getListenerId() == notificationId);
        }
    }

    public void notify(Date date, Date newDate) {
        if (listeners.containsKey(date)) {
            for (EventListener listener : listeners.get(date)) {
                listener.update(newDate);
            }
        }
    }
}

