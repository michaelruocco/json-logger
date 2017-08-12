package uk.co.mruoc.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoggerFactory {

    private static final Gson GSON = new GsonBuilder()
            .disableHtmlEscaping()
            .serializeNulls()
            .create();


    public static Logger getLogger(String name, VariableAppender variableAppender) {
        org.slf4j.Logger slf4jLogger = org.slf4j.LoggerFactory.getLogger(name);
        return new EnvironmentVariableLogger(slf4jLogger, GSON, variableAppender);
    }

    public static Logger getLogger(Class<?> clazz, VariableAppender variableAppender) {
        org.slf4j.Logger slf4jLogger = org.slf4j.LoggerFactory.getLogger(clazz);
        return new EnvironmentVariableLogger(slf4jLogger, GSON, variableAppender);
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
