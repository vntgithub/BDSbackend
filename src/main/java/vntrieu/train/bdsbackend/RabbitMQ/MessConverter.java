package vntrieu.train.bdsbackend.RabbitMQ;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MessageConverter;

public class MessConverter implements MessageConverter {

    @Override
    public Object fromMessage(Message<?> message, Class<?> aClass) {
        return null;
    }

    @Override
    public Message<?> toMessage(Object o, MessageHeaders messageHeaders) {
        return null;
    }
}
