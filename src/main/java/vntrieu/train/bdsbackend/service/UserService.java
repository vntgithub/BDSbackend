package vntrieu.train.bdsbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.dto.UserDTO;
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

  public User getById(Long id) {
    return repository.getById(id);
  }

  public User add(User u){
    //Create account
    Account newAccount = accountRepository.save(u.getAccount());
    u.setAccount(newAccount);
    //create address
    Address newAddress = addressRepository.save(u.getAddress());
    u.setAddress(newAddress);
    //create contact
    Contact newContact = contactRepository.save(u.getContact());
    u.setContact(newContact);
    //create ob user
    User newUser =  repository.save(u);
    //Add foreign key
    newAccount.setUser(newUser);
    newAddress.setUser(newUser);
    newContact.setUser(newUser);
    accountRepository.save(newAccount);
    addressRepository.save(newAddress);
    contactRepository.save(newContact);
    //Return data
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
