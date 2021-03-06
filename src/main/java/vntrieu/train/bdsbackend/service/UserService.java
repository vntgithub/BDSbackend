package vntrieu.train.bdsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.User;
import vntrieu.train.bdsbackend.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private  UserRepository repository;

  public User getById(Long id) {
    return repository.getById(id);
  }


  public User update(User u){
    repository.findById(u.getId())
        .map(rs -> {
          rs.setName(u.getName());
          rs.setAvt(u.getAvt());
          rs.setDateOfBirth(u.getDateOfBirth());
          rs.setGender(u.getGender());
          return repository.save(rs);
        });
    return repository.getById(u.getId());
  }

  public String delete(Long id){
    repository.deleteById(id);
    return "Deleted!";
  }
  public Long countPage (){return repository.count();}

  public List<User> getByPage(Pageable page) {
      return repository.findAllBy(page);
  }

}
