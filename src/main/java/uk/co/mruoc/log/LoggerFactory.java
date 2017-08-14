package uk.co.mruoc.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoggerFactory {

    private static final Gson GSON = new GsonBuilder()
            .disableHtmlEscaping()
            .serializeNulls()
            .create();

    private static final VariableAppender VARIABLE_APPENDER = new NoopVariableAppender();

    public static Logger getLogger(String name) {
        return getLogger(name, GSON, VARIABLE_APPENDER);
    }

    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz, GSON, VARIABLE_APPENDER);
    }

    public static Logger getLogger(String name, Gson gson) {
        return getLogger(name, gson, VARIABLE_APPENDER);
    }

    public static Logger getLogger(Class<?> clazz, Gson gson) {
        return getLogger(clazz, gson, VARIABLE_APPENDER);
    }

    public static Logger getLogger(String name, VariableAppender variableAppender) {
        return getLogger(name, GSON, variableAppender);
    }

    public static Logger getLogger(Class<?> clazz, VariableAppender variableAppender) {
        return getLogger(clazz, GSON, variableAppender);
    }

    public static Logger getLogger(String name, Gson gson, VariableAppender variableAppender) {
        org.slf4j.Logger slf4jLogger = org.slf4j.LoggerFactory.getLogger(name);
        return new EnvironmentVariableLogger(slf4jLogger, gson, variableAppender);
    }

    public static Logger getLogger(Class<?> clazz, Gson gson, VariableAppender variableAppender) {
        org.slf4j.Logger slf4jLogger = org.slf4j.LoggerFactory.getLogger(clazz);
        return new EnvironmentVariableLogger(slf4jLogger, gson, variableAppender);
    }

}
