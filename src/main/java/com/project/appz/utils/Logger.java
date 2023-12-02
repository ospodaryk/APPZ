package com.project.appz.utils;

public class Logger {
    private static volatile Logger instance;

    public static Logger getInstance() {
        Logger result = instance;

        if (result != null) {
            return result;
        }

        synchronized (Logger.class) {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }
    }

    public void log(String method, String message) {
        // logging
    }

    public void debug(String method, String message) {
        // logging
    }

    public void error(String method, String message) {
        // logging
    }

    public void warn(String method, String message) {
        // logging
    }
}
