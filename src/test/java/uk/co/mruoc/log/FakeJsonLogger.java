package uk.co.mruoc.log;

import com.google.gson.JsonElement;
import com.savoirtech.logging.slf4j.json.logger.JsonLogger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class FakeJsonLogger implements JsonLogger {

    private Map<String, Object> fields = new HashMap<>();
    private Map<String, List<Object>> listFields = new HashMap<>();

    @Override
    public JsonLogger message(String message) {
        return null;
    }

    @Override
    public JsonLogger message(Supplier<String> message) {
        return null;
    }

    @Override
    public JsonLogger map(String key, Map map) {
        return null;
    }

    @Override
    public JsonLogger map(String key, Supplier<Map> map) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JsonLogger list(String key, List list) {
        listFields.put(key, list);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JsonLogger list(String key, Supplier<List> list) {
        listFields.put(key, list.get());
        return this;
    }

    @Override
    public JsonLogger field(String key, Object value) {
        fields.put(key, value);
        return this;
    }

    @Override
    public JsonLogger field(String key, Supplier value) {
        fields.put(key, value.get());
        return this;
    }

    @Override
    public JsonLogger json(String key, JsonElement jsonElement) {
        return null;
    }

    @Override
    public JsonLogger json(String key, Supplier<JsonElement> jsonElement) {
        return null;
    }

    @Override
    public JsonLogger exception(String key, Exception exception) {
        return null;
    }

    @Override
    public JsonLogger stack() {
        return null;
    }

    @Override
    public void log() {
        // intentionally blank
    }

    public boolean hasField(String key) {
        return fields.containsKey(key);
    }

    public Object getFieldValue(String key) {
        return fields.get(key);
    }

    public boolean hasListField(String key) {
        return listFields.containsKey(key);
    }

    public List<Object> getListFieldValue(String key) {
        return listFields.get(key);
    }

}
