package vntrieu.train.bdsbackend.RabbitMQ;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Message.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String type;
    private String contact;
}
