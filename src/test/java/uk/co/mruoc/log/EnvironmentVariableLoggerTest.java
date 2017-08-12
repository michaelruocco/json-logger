package uk.co.mruoc.log;

import com.savoirtech.logging.slf4j.json.logger.JsonLogger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import static org.assertj.core.api.Assertions.assertThat;

public class EnvironmentVariableLoggerTest {

    private static final String VARIABLE_NAME_1 = "ENV_VAR_1";
    private static final String VARIABLE_NAME_2 = "ENV_VAR_2";
    private static final String VARIABLE_NAME_3 = "ENV_VAR_3";

    private static final String VALUE_1 = "value1";
    private static final String VALUE_2 = "value2";
    private static final String VALUE_3 = "value3, value3";

    private static final String EXPECTED_ENV_VAR_1 = "\"ENV_VAR_1\":\"value1\"";
    private static final String EXPECTED_ENV_VAR_3 = "\"ENV_VAR_3\":[\"value3\",\"value3\"]";

    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    private final FakeSlf4jLogger slf4jLogger = new FakeSlf4jLogger();
    private final VariableAppender appender = new EnvironmentVariableAppender(VARIABLE_NAME_1, VARIABLE_NAME_3);
    private final EnvironmentVariableLogger variableLogger = new EnvironmentVariableLogger(slf4jLogger, appender);

    @Before
    public void setUp() {
        environmentVariables.set(VARIABLE_NAME_1, VALUE_1);
        environmentVariables.set(VARIABLE_NAME_2, VALUE_2);
        environmentVariables.set(VARIABLE_NAME_3, VALUE_3);
    }

    @Test
    public void traceShouldAddEnvironmentVariablesConfiguredInAppender() {
        slf4jLogger.setTraceEnabled(true);

        JsonLogger jsonLogger = variableLogger.trace();

        assertThat(jsonLogger.toString()).contains(EXPECTED_ENV_VAR_1);
        assertThat(jsonLogger.toString()).contains(EXPECTED_ENV_VAR_3);
        assertThat(jsonLogger.toString()).contains("\"level\":\"TRACE\"");
    }

    @Test
    public void debugShouldAddEnvironmentVariablesConfiguredInAppender() {
        slf4jLogger.setDebugEnabled(true);

        JsonLogger jsonLogger = variableLogger.debug();

        assertThat(jsonLogger.toString()).contains(EXPECTED_ENV_VAR_1);
        assertThat(jsonLogger.toString()).contains(EXPECTED_ENV_VAR_3);
        assertThat(jsonLogger.toString()).contains("\"level\":\"DEBUG\"");
    }

    @Test
    public void infoShouldAddEnvironmentVariablesConfiguredInAppender() {
        slf4jLogger.setInfoEnabled(true);

        JsonLogger jsonLogger = variableLogger.info();

        assertThat(jsonLogger.toString()).contains(EXPECTED_ENV_VAR_1);
        assertThat(jsonLogger.toString()).contains(EXPECTED_ENV_VAR_3);
        assertThat(jsonLogger.toString()).contains("\"level\":\"INFO\"");
    }

    @Test
    public void warnShouldAddEnvironmentVariablesConfiguredInAppender() {
        slf4jLogger.setWarnEnabled(true);

        JsonLogger jsonLogger = variableLogger.warn();

        assertThat(jsonLogger.toString()).contains(EXPECTED_ENV_VAR_1);
        assertThat(jsonLogger.toString()).contains(EXPECTED_ENV_VAR_3);
        assertThat(jsonLogger.toString()).contains("\"level\":\"WARN\"");
    }

    @Test
    public void errorShouldAddEnvironmentVariablesConfiguredInAppender() {
        slf4jLogger.setErrorEnabled(true);

        JsonLogger jsonLogger = variableLogger.error();

        assertThat(jsonLogger.toString()).contains(EXPECTED_ENV_VAR_1);
        assertThat(jsonLogger.toString()).contains(EXPECTED_ENV_VAR_3);
        assertThat(jsonLogger.toString()).contains("\"level\":\"ERROR\"");
    }

}
