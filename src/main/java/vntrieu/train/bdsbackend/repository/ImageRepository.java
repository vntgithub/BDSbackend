package vntrieu.train.bdsbackend.repository;

import   vntrieu.train.bdsbackend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {

}
