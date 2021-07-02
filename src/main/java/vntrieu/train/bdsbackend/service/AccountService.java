package vntrieu.train.bdsbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Account;
import vntrieu.train.bdsbackend.model.AccountDetails;
import vntrieu.train.bdsbackend.model.User;
import vntrieu.train.bdsbackend.repository.AccountRepository;


@Service
@AllArgsConstructor
public class AccountService implements UserDetailsService {

  @Autowired
  private final AccountRepository accountRepository;


  @Override
  public AccountDetails loadUserByUsername(String username) {
    // Kiểm tra xem user có tồn tại trong database không?
    Account account = accountRepository.findById(username).get();
    if (account == null) {
      throw new UsernameNotFoundException(username);
    }

    return new AccountDetails(account);
  }
  public User getByUsername(String username){return accountRepository.getById(username).getUser();}

  public User add(Account account){
    String hashedPassword = BCrypt.hashpw(account.getPassword(), BCrypt.gensalt());
    account.setPassword(hashedPassword);
    User newUser =  accountRepository.save(account).getUser();
    return newUser;
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

