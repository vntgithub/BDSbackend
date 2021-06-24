package vntrieu.train.bdsbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.repository.ImageRepository;
@AllArgsConstructor
@Service
public class ImageService {
  private ImageRepository repository;

  String delete(Long id){
    repository.deleteById(id);
    return "Deleted";
  }

}
