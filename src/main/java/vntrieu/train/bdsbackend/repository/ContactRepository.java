package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vntrieu.train.bdsbackend.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
