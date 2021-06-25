package vntrieu.train.bdsbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.dto.AccountDTO;
import vntrieu.train.bdsbackend.model.Account;
import vntrieu.train.bdsbackend.model.User;
import vntrieu.train.bdsbackend.repository.AccountRepository;
import vntrieu.train.bdsbackend.repository.UserRepository;

@AllArgsConstructor
@Service
public class AccountService {
  private final AccountRepository accountRepository;
  private final UserRepository userRepository;
  private final String salt = "$2a$10$OGRpSyzszLt6XX8regIQde";

  public User add(Account account){
    String hashedPassword = BCrypt.hashpw(account.getPassword(), salt);
    account.setPassword(hashedPassword);
    return accountRepository.save(account).getUser();
  }

  public User login(AccountDTO a){
    String username = a.getUsername();
    String pass = a.getPassword();
    if(accountRepository.existsById(username)){
      Account accountLoggin = accountRepository.getById(username);
      String hashedPassLogin = BCrypt.hashpw(pass, salt);
      String hashedPassInDB = accountLoggin.getPassword();
      if(hashedPassInDB.equals(hashedPassLogin)){
        return userRepository.getById(accountLoggin.getUser().getId());
      }
    }
    return new User();
  }
  public String update(Account a) {
     if(accountRepository.existsById(a.getUsername())){
       accountRepository.save(a);
       return "Done!";
     }
     return "ERR";
  }
  public String delete(String username){
    accountRepository.deleteById(username);
    return "Deleted!";
  }

}
