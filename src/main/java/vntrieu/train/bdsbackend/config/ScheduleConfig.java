package vntrieu.train.bdsbackend.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import vntrieu.train.bdsbackend.RabbitMQ.RabbitMQSender;
import vntrieu.train.bdsbackend.model.MessageModel;
import vntrieu.train.bdsbackend.repository.MessageRepository;

import java.util.HashMap;
import java.util.List;


@Configuration
@EnableScheduling
@EnableAsync
public class ScheduleConfig {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    public String getPriceRangeString(Long price) {
        if(price < 500000000)
            return "0";
        if(price >= 500000000 && price < 1000000000)
            return "1";
        if(price >=1000000000 && price < 1500000000)
            return "2";
        if(price >=1500000000 && price <2000000000)
            return "3";
        return "4";
    }
    @Scheduled(cron = "0 0 10 * * ?")//Send at 10:00 everyday
    @Async
    public void scheduleFixedDelayTask() throws InterruptedException{
        //Send mess to send mail service
        List<MessageModel> list = messageRepository.findAll();
        if(!list.isEmpty()){
            for(MessageModel m : list){
                HashMap<String, Object> mess = new HashMap<String, Object>();
                mess.put("nameUser", m.getContact().getUser().getName());
                mess.put("email", m.getContact().getEmail());
                mess.put("listId", m.getListProductId());
                rabbitMQSender.send(mess);
            }

            //Clear table mess
            messageRepository.deleteAll();
        }
    }

}
