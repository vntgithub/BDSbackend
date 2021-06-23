package vntrieu.train.bdsbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Account;
import vntrieu.train.bdsbackend.repository.AccountRepository;
@AllArgsConstructor
@Service
public class AccountService {
  private final AccountRepository repository;

  public void add(Account a) {
    repository.save(a);
  }
  public void update(Account a) {
    repository.findById(a.getUsername())
        .map(rs -> {
          rs = a;
          return repository.save(rs);
        });
  }
  public void delete(String username){
    repository.findById(username);
  }
}
