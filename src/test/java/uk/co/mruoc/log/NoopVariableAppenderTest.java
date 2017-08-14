package uk.co.mruoc.log;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NoopVariableAppenderTest {

    private final FakeJsonLogger logger = new FakeJsonLogger();

    private final NoopVariableAppender appender = new NoopVariableAppender();

    @Test
    public void shouldReturJsonLogger() {
        assertThat(appender.append(logger)).isEqualTo(logger);
    }

}
