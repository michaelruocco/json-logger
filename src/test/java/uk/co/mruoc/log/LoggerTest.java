package uk.co.mruoc.log;

import com.google.gson.Gson;
import com.savoirtech.logging.slf4j.json.logger.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoggerTest {

    private final Gson gson = new Gson();
    private final FakeSlf4jLogger slf4jLogger = new FakeSlf4jLogger();
    private final Logger logger = new Logger(slf4jLogger, gson);

    @Test
    public void traceShouldReturnNoopLoggerIfNotEnabled() {
        JsonLogger jsonLogger = logger.trace();

        assertThat(jsonLogger).isInstanceOf(NoopLogger.class);
    }

    @Test
    public void traceShouldReturnTraceLoggerIfEnabled() {
        slf4jLogger.setTraceEnabled(true);

        JsonLogger jsonLogger = logger.trace();

        assertThat(jsonLogger).isInstanceOf(TraceLogger.class);
    }

    @Test
    public void debugShouldReturnNoopLoggerIfNotEnabled() {
        JsonLogger jsonLogger = logger.debug();

        assertThat(jsonLogger).isInstanceOf(NoopLogger.class);
    }

    @Test
    public void debugShouldReturnDebugLoggerIfEnabled() {
        slf4jLogger.setDebugEnabled(true);

        JsonLogger jsonLogger = logger.debug();

        assertThat(jsonLogger).isInstanceOf(DebugLogger.class);
    }

    @Test
    public void infoShouldReturnNoopLoggerIfNotEnabled() {
        JsonLogger jsonLogger = logger.info();

        assertThat(jsonLogger).isInstanceOf(NoopLogger.class);
    }

    @Test
    public void infoShouldReturnInfoLoggerIfEnabled() {
        slf4jLogger.setInfoEnabled(true);

        JsonLogger jsonLogger = logger.info();

        assertThat(jsonLogger).isInstanceOf(InfoLogger.class);
    }

    @Test
    public void warnShouldReturnNoopLoggerIfNotEnabled() {
        JsonLogger jsonLogger = logger.warn();

        assertThat(jsonLogger).isInstanceOf(NoopLogger.class);
    }

    @Test
    public void warnShouldReturnWarnLoggerIfEnabled() {
        slf4jLogger.setWarnEnabled(true);

        JsonLogger jsonLogger = logger.warn();

        assertThat(jsonLogger).isInstanceOf(WarnLogger.class);
    }

    @Test
    public void errorShouldReturnNoopLoggerIfNotEnabled() {
        JsonLogger jsonLogger = logger.error();

        assertThat(jsonLogger).isInstanceOf(NoopLogger.class);
    }

    @Test
    public void errorShouldReturnErrorLoggerIfEnabled() {
        slf4jLogger.setErrorEnabled(true);

        JsonLogger jsonLogger = logger.error();

        assertThat(jsonLogger).isInstanceOf(ErrorLogger.class);
    }

    /*@Test
    @Test
    public void errorShouldAddEnvironmentVariablesConfiguredInAppender() {
        slf4jLogger.setErrorEnabled(true);

        JsonLogger jsonLogger = variableLogger.error();

        assertThat(jsonLogger.toString()).contains("\"ENV_VAR_1\":\"value1\"");
        assertThat(jsonLogger.toString()).contains("\"ENV_VAR_3\":[\"value3\",\" value3\"]");
        assertThat(jsonLogger.toString()).contains("\"level\":\"ERROR\"");
    }*/

}
