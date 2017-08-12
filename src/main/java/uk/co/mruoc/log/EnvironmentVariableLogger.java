package uk.co.mruoc.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.savoirtech.logging.slf4j.json.logger.*;

public class EnvironmentVariableLogger extends Logger {

    private final VariableAppender variableAppender;

    public EnvironmentVariableLogger(org.slf4j.Logger slf4jLogger, VariableAppender variableAppender) {
        this(slf4jLogger, new GsonBuilder().disableHtmlEscaping().serializeNulls().create(), variableAppender);
    }

    public EnvironmentVariableLogger(org.slf4j.Logger slf4jLogger, Gson gson, VariableAppender variableAppender) {
        super(slf4jLogger, gson);
        this.variableAppender = variableAppender;
    }

    public JsonLogger trace() {
        return variableAppender.append(super.trace());
    }

    public JsonLogger debug() {
        return variableAppender.append(super.debug());
    }

    public JsonLogger info() {
        return variableAppender.append(super.info());
    }

    public JsonLogger warn() {
        return variableAppender.append(super.warn());
    }

    public JsonLogger error() {
        return variableAppender.append(super.error());
    }

}
