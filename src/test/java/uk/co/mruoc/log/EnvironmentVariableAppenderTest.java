package uk.co.mruoc.log;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import static org.assertj.core.api.Assertions.assertThat;

public class EnvironmentVariableAppenderTest {

    private static final String VARIABLE_NAME_1 = "ENV_VAR_1";
    private static final String VARIABLE_NAME_2 = "ENV_VAR_2";
    private static final String VARIABLE_NAME_3 = "ENV_VAR_3";

    private static final String VALUE_1 = "value1";
    private static final String VALUE_2 = "value2";
    private static final String VALUE_3 = "value3, value3";

    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    private final FakeJsonLogger logger = new FakeJsonLogger();

    @Before
    public void setUp() {
        environmentVariables.set(VARIABLE_NAME_1, VALUE_1);
        environmentVariables.set(VARIABLE_NAME_2, VALUE_2);
        environmentVariables.set(VARIABLE_NAME_3, VALUE_3);
    }

    @Test
    public void shouldNotAppendEnvironmentVariableToLoggerIfNotPassedToAppender() {
        VariableAppender appender = new EnvironmentVariableAppender();

        appender.append(logger);

        assertThat(logger.hasField(VARIABLE_NAME_1)).isFalse();
        assertThat(logger.hasField(VARIABLE_NAME_2)).isFalse();
        assertThat(logger.hasField(VARIABLE_NAME_3)).isFalse();
    }

    @Test
    public void shouldAppendEnvironmentVariableToLogger() {
        VariableAppender appender = new EnvironmentVariableAppender(VARIABLE_NAME_1);

        appender.append(logger);

        assertThat(logger.hasField(VARIABLE_NAME_1)).isTrue();
        assertThat(logger.hasField(VARIABLE_NAME_2)).isFalse();
        assertThat(logger.hasField(VARIABLE_NAME_3)).isFalse();
        assertThat(logger.getFieldValue(VARIABLE_NAME_1)).isEqualTo(VALUE_1);
    }

    @Test
    public void shouldAppendMultipleEnvironmentVariableToLogger() {
        VariableAppender appender = new EnvironmentVariableAppender(VARIABLE_NAME_1, VARIABLE_NAME_2);

        appender.append(logger);

        assertThat(logger.hasField(VARIABLE_NAME_1)).isTrue();
        assertThat(logger.hasField(VARIABLE_NAME_2)).isTrue();
        assertThat(logger.hasField(VARIABLE_NAME_3)).isFalse();
        assertThat(logger.getFieldValue(VARIABLE_NAME_1)).isEqualTo(VALUE_1);
        assertThat(logger.getFieldValue(VARIABLE_NAME_2)).isEqualTo(VALUE_2);
    }

    @Test
    public void shouldAppendListEnvironmentVariableToLogger() {
        VariableAppender appender = new EnvironmentVariableAppender(VARIABLE_NAME_3);

        appender.append(logger);

        assertThat(logger.hasField(VARIABLE_NAME_1)).isFalse();
        assertThat(logger.hasField(VARIABLE_NAME_2)).isFalse();
        assertThat(logger.hasListField(VARIABLE_NAME_3)).isTrue();
        assertThat(logger.getListFieldValue(VARIABLE_NAME_3)).containsExactly("value3", "value3");
    }

}
