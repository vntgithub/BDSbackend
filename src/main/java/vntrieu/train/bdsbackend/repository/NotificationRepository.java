package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vntrieu.train.bdsbackend.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
