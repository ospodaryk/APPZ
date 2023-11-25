package com.project.appz.servises;

import com.project.appz.entities.Notification;

import java.util.Date;

public interface EventListener {
    public long getListenerId();
    void update(Date newDate);
}
