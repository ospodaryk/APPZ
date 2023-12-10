package com.project.appz.service.notification;


import java.time.LocalDate;

public interface EventListener {
    long getListenerId();
    void update();
}