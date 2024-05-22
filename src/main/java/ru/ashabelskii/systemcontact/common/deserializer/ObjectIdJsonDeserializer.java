package ru.ashabelskii.systemcontact.common.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;

import java.io.IOException;


public class ObjectIdJsonDeserializer extends JsonDeserializer<ObjectId> {

    @Override
    public ObjectId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonToken jsonToken = p.currentToken();
        String str = jsonToken.isScalarValue() ? p.readValueAs(String.class) : p.readValueAs(JsonNode.class).asText();
        return StringUtils.isNotBlank(str) ? new ObjectId(str) : null;
    }

}
