package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.model.Contact;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT DISTINCT contact.id, contact.email, contact.phone_number " +
            "FROM filter INNER JOIN person on filter.user_id = person.id " +
            "INNER JOIN contact ON contact.id = person.contact_id " +
            "WHERE (cast (filter.content->'streetId' as varchar)= ?1 OR cast (filter.content->'wardId' as varchar)= ?2) " +
            "OR (cast(filter.content->'priceRange' as varchar) = ?3 AND " +
            "cast (filter.content->'streetId' as varchar)= ?1 OR cast (filter.content->'wardId' as varchar)= ?2)", nativeQuery = true)
     List<Contact> searchContact(String streetId, String wardId, String priceRange);
}
