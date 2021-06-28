package vntrieu.train.bdsbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.junit.Test;
import vntrieu.train.bdsbackend.model.HashMapConverter;

import javax.persistence.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@Entity
@Table(name = "Filter")
@TypeDef(name = "json", typeClass = JsonFormatTypes.class)
@Data
public class Filter {

    @Id
    @SequenceGenerator(name = "filter_sequence", sequenceName = "filter_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filter_sequence")
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @Convert(converter = HashMapConverter.class, disableConversion = true)
    @Type( type = "json" )
    private Map<String, Object> content;

//    public String getJSONContent() throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(content);
//    }
//
//    public HashMap deserializeContent(String contentJSON) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return  objectMapper.readValue(contentJSON, HashMap.class);
//    }

}
