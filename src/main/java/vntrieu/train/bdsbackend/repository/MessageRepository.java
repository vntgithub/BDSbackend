package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vntrieu.train.bdsbackend.model.MessageModel;

public interface MessageRepository extends JpaRepository<MessageModel, Long> {
}
