package com.project.appz.utils;
import java.io.PrintStream;

public class Logger {
    private static volatile Logger instance;
    private final PrintStream output;

    private Logger(PrintStream output) {
        this.output = output;
    }

    public static Logger getInstance(PrintStream output) {
        Logger result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Logger.class) {
            if (instance == null) {
                instance = new Logger(output);
            }
            return instance;
        }
    }

    public void log(String method) {
        output.println("LOG [" + method + "]: ");
    }

    public void debug(String method, String message) {
        output.println("DEBUG [" + method + "]: " + message);
    }

    public void error(String method, String message) {
        output.println("ERROR [" + method + "]: " + message);
    }

    public void warn(String method, String message) {
        output.println("WARN [" + method + "]: " + message);
    }
}
