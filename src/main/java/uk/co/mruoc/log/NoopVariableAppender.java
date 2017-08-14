package uk.co.mruoc.log;

import com.savoirtech.logging.slf4j.json.logger.JsonLogger;

public class NoopVariableAppender implements VariableAppender {

    @Override
    public JsonLogger append(JsonLogger jsonLogger) {
        return jsonLogger;
    }

}
