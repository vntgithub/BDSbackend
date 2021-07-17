package vntrieu.train.bdsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.repository.ImageRepository;
@Service
public class ImageService {
  @Autowired
  private ImageRepository repository;

  String delete(Long id){
    repository.deleteById(id);
    return "Deleted";
  }

}
