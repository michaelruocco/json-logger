package uk.co.mruoc.log;

import com.google.gson.Gson;
import com.savoirtech.logging.slf4j.json.logger.*;
import org.apache.commons.lang3.time.FastDateFormat;

public class Logger {

    private static final FastDateFormat DATE_FORMATTER = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSSZ");
    private static final boolean INCLUDE_LOGGER_NAME = false;

    private final NoopLogger noopLogger = new NoopLogger();

    private final org.slf4j.Logger slf4jLogger;
    private final Gson gson;

    public Logger(org.slf4j.Logger slf4jLogger, Gson gson) {
        this.slf4jLogger = slf4jLogger;
        this.gson = gson;
    }

    public JsonLogger trace() {
        if (slf4jLogger.isTraceEnabled())
            return new TraceLogger(slf4jLogger, DATE_FORMATTER, gson, INCLUDE_LOGGER_NAME);
        return noopLogger;
    }

    public JsonLogger debug() {
        if (slf4jLogger.isDebugEnabled())
            return new DebugLogger(slf4jLogger, DATE_FORMATTER, gson, INCLUDE_LOGGER_NAME);
        return noopLogger;
    }

    public JsonLogger info() {
        if (slf4jLogger.isInfoEnabled())
            return new InfoLogger(slf4jLogger, DATE_FORMATTER, gson, INCLUDE_LOGGER_NAME);
        return noopLogger;
    }

    public JsonLogger warn() {
        if (slf4jLogger.isWarnEnabled())
            return new WarnLogger(slf4jLogger, DATE_FORMATTER, gson, INCLUDE_LOGGER_NAME);
        return noopLogger;
    }

    public JsonLogger error() {
        if (slf4jLogger.isErrorEnabled())
            return new ErrorLogger(slf4jLogger, DATE_FORMATTER, gson, INCLUDE_LOGGER_NAME);
        return noopLogger;
    }







}
