package com.project.appz.service.notification;


public interface EventListener {
    long getListenerId();

    void update();
}