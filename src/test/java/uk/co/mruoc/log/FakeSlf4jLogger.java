package uk.co.mruoc.log;

import org.slf4j.Marker;

public class FakeSlf4jLogger implements org.slf4j.Logger {

    private boolean traceEnabled;
    private boolean debugEnabled;
    private boolean infoEnabled;
    private boolean warnEnabled;
    private boolean errorEnabled;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isTraceEnabled() {
        return traceEnabled;
    }

    @Override
    public void trace(String msg) {
        // intentionally blank
    }

    @Override
    public void trace(String format, Object arg) {
        // intentionally blank
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        // intentionally blank
    }

    @Override
    public void trace(String format, Object... arguments) {
        // intentionally blank
    }

    @Override
    public void trace(String msg, Throwable t) {
        // intentionally blank
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return traceEnabled;
    }

    @Override
    public void trace(Marker marker, String msg) {
        // intentionally blank
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        // intentionally blank
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        // intentionally blank
    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {
        // intentionally blank
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        // intentionally blank
    }

    @Override
    public boolean isDebugEnabled() {
        return debugEnabled;
    }

    @Override
    public void debug(String msg) {
        // intentionally blank
    }

    @Override
    public void debug(String format, Object arg) {
        // intentionally blank
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        // intentionally blank
    }

    @Override
    public void debug(String format, Object... arguments) {
        // intentionally blank
    }

    @Override
    public void debug(String msg, Throwable t) {
        // intentionally blank
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return debugEnabled;
    }

    @Override
    public void debug(Marker marker, String msg) {
        // intentionally blank
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        // intentionally blank
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        // intentionally blank
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        // intentionally blank
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        // intentionally blank
    }

    @Override
    public boolean isInfoEnabled() {
        return infoEnabled;
    }

    @Override
    public void info(String msg) {
        // intentionally blank
    }

    @Override
    public void info(String format, Object arg) {
        // intentionally blank
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        // intentionally blank
    }

    @Override
    public void info(String format, Object... arguments) {
        // intentionally blank
    }

    @Override
    public void info(String msg, Throwable t) {
        // intentionally blank
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return infoEnabled;
    }

    @Override
    public void info(Marker marker, String msg) {
        // intentionally blank
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        // intentionally blank
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        // intentionally blank
    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        // intentionally blank
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        // intentionally blank
    }

    @Override
    public boolean isWarnEnabled() {
        return warnEnabled;
    }

    @Override
    public void warn(String msg) {
        // intentionally blank
    }

    @Override
    public void warn(String format, Object arg) {
        // intentionally blank
    }

    @Override
    public void warn(String format, Object... arguments) {
        // intentionally blank
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        // intentionally blank
    }

    @Override
    public void warn(String msg, Throwable t) {
        // intentionally blank
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return warnEnabled;
    }

    @Override
    public void warn(Marker marker, String msg) {
        // intentionally blank
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        // intentionally blank
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        // intentionally blank
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        // intentionally blank
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        // intentionally blank
    }

    @Override
    public boolean isErrorEnabled() {
        return errorEnabled;
    }

    @Override
    public void error(String msg) {
        // intentionally blank
    }

    @Override
    public void error(String format, Object arg) {
        // intentionally blank
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        // intentionally blank
    }

    @Override
    public void error(String format, Object... arguments) {
        // intentionally blank
    }

    @Override
    public void error(String msg, Throwable t) {
        // intentionally blank
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return errorEnabled;
    }

    @Override
    public void error(Marker marker, String msg) {
        // intentionally blank
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        // intentionally blank
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        // intentionally blank
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        // intentionally blank
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        // intentionally blank
    }

    public void setTraceEnabled(boolean traceEnabled) {
        this.traceEnabled = traceEnabled;
    }

    public void setDebugEnabled(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
    }

    public void setInfoEnabled(boolean infoEnabled) {
        this.infoEnabled = infoEnabled;
    }

    public void setWarnEnabled(boolean warnEnabled) {
        this.warnEnabled = warnEnabled;
    }

    public void setErrorEnabled(boolean errorEnabled) {
        this.errorEnabled = errorEnabled;
    }

}
