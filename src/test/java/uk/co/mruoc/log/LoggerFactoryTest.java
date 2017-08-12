package uk.co.mruoc.log;

import com.google.gson.Gson;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoggerFactoryTest {

    @Test
    public void shouldReturnEnvironmentVariableLoggerUsingName() {
        Logger logger = LoggerFactory.getLogger("name", new EnvironmentVariableAppender());

        assertThat(logger).isInstanceOf(EnvironmentVariableLogger.class);
    }

    @Test
    public void shouldReturnEnvironmentVariableLoggerUsingClass() {
        Logger logger = LoggerFactory.getLogger(LoggerFactoryTest.class, new EnvironmentVariableAppender());

        assertThat(logger).isInstanceOf(EnvironmentVariableLogger.class);
    }

    @Test
    public void shouldReturnEnvironmentVariableLoggerUsingNameWithGson() {
        Logger logger = LoggerFactory.getLogger("name", new Gson(), new EnvironmentVariableAppender());

        assertThat(logger).isInstanceOf(EnvironmentVariableLogger.class);
    }

    @Test
    public void shouldReturnEnvironmentVariableLoggerUsingClassWithGson() {
        Logger logger = LoggerFactory.getLogger(LoggerFactoryTest.class, new Gson(), new EnvironmentVariableAppender());

        assertThat(logger).isInstanceOf(EnvironmentVariableLogger.class);
    }

}
