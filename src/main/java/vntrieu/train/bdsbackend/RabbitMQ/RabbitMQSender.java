package vntrieu.train.bdsbackend.RabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    //    @Value("${RABBITMQ_EXCHANGE:}")
    private String exchange = "sendMail-service-exchange";

    //    @Value("${RABBITMQ_ROUTINGKEY:}")
    private String routingkey = "foo.bar.#";

    public void send(HashMap<String, Object> message) {

        rabbitTemplate.convertAndSend(exchange, routingkey, message);
        System.out.println("Send msg = " + message);
    }


}
