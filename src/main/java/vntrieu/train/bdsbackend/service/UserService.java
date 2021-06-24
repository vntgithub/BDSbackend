package vntrieu.train.bdsbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Account;
import vntrieu.train.bdsbackend.model.Address;
import vntrieu.train.bdsbackend.model.Contact;
import vntrieu.train.bdsbackend.model.User;
import vntrieu.train.bdsbackend.repository.AccountRepository;
import vntrieu.train.bdsbackend.repository.AddressRepository;
import vntrieu.train.bdsbackend.repository.ContactRepository;
import vntrieu.train.bdsbackend.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
  private final UserRepository repository;
  private  final AccountRepository accountRepository;
  private final ContactRepository contactRepository;
  private final AddressRepository addressRepository;
  private final String salt = "$2a$10$OGRpSyzszLt6XX8regIQde";

  public User getById(Long id) {
    return repository.getById(id);
  }

  public User add(User u){

    //Create user
    User newUser =  repository.save(u);

    //Update foreign key
    Account newAccount = newUser.getAccount();
    newAccount.setPassword(BCrypt.hashpw(newAccount.getPassword(), salt));
    newAccount.setUser(newUser);
    accountRepository.save(newAccount);

    Address newAddress = newUser.getAddress();
    newAddress.setUser(newUser);
    addressRepository.save(newAddress);

    Contact newContact = newUser.getContact();
    newContact.setUser(newUser);
    contactRepository.save(newContact);

    return newUser;
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

}
