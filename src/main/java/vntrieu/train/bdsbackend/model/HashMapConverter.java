package vntrieu.train.bdsbackend.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Map;

public class HashMapConverter implements AttributeConverter <Map<String, Object>, String>{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> content) {

        String contentJson = null;
        try {
            contentJson = objectMapper.writeValueAsString(content);
        } catch (final JsonProcessingException e) {
            System.out.println("JSON writing error" + e);
        }

        return contentJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String contentJson) {

        Map<String, Object> content = null;
        try {
            content = objectMapper.readValue(contentJson, Map.class);
        } catch (final IOException e) {
            System.out.println("JSON reading error" + e);
        }

        return content;
    }

}
