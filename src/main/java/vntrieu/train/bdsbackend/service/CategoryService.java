package vntrieu.train.bdsbackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Category;

import vntrieu.train.bdsbackend.repository.CategoryRepository;
@Service
public class CategoryService {

  @Autowired
  private  CategoryRepository repository;

  public List<Category> getAll(){return repository.findAll();}

  public Category add(Category c){return repository.save(c);}

  public Category update(Category c){
    if(repository.existsById(c.getId()))
      return repository.save(c);
    return null;
  }

  public String delete(Integer id){
    repository.deleteById(id);
    return "Deteled!";
  }
}
