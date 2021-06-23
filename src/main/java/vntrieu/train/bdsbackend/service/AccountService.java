package vntrieu.train.bdsbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Account;
import vntrieu.train.bdsbackend.repository.AccountRepository;
@AllArgsConstructor
@Service
public class AccountService {
  private final AccountRepository repository;

  public String update(Account a) {
     if(repository.existsById(a.getUsername())){
       repository.save(a);
       return "Done!";
     }
     return "ERR";
  }
  public String delete(String username){
    repository.deleteById(username);
    return "Deleted!";
  }
}
