package uk.co.mruoc.log;

import com.savoirtech.logging.slf4j.json.logger.JsonLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnvironmentVariableAppender implements VariableAppender {

    private List<String> environmentVariableNames;

    public EnvironmentVariableAppender(String... environmentVariableNames) {
        this(Arrays.asList(environmentVariableNames));
    }

    public EnvironmentVariableAppender(List<String> environmentVariableNames) {
        this.environmentVariableNames = environmentVariableNames;
    }

    @Override
    public JsonLogger append(JsonLogger jsonLogger) {
        for (String variableName : environmentVariableNames)
            jsonLogger = append(jsonLogger, variableName);
        return jsonLogger;
    }

    private static JsonLogger append(JsonLogger jsonLogger, String variableName) {
        String value = System.getenv(variableName);
        if (isList(value))
            return jsonLogger.list(variableName, toList(value));
        return jsonLogger.field(variableName, value);
    }

    private static boolean isList(String value) {
        return value != null && value.contains(",");
    }

    private static List<String> toList(String input) {
        List<String> inputs = Arrays.asList(input.split(","));
        List<String> result = new ArrayList<>();
        inputs.forEach(i -> result.add(i.trim()));
        return result;
    }

}
