package uk.co.mruoc.log;

import com.savoirtech.logging.slf4j.json.logger.JsonLogger;

public interface VariableAppender {

    JsonLogger append(JsonLogger jsonLogger);

}
