package vntrieu.train.bdsbackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vntrieu.train.bdsbackend.dto.AccountDTO;
import vntrieu.train.bdsbackend.dto.UserDTO;
import vntrieu.train.bdsbackend.model.Account;
import vntrieu.train.bdsbackend.service.AccountService;
@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
  private final AccountService accountService;

  @PostMapping
  UserDTO login(@RequestBody AccountDTO account){
    return new UserDTO(accountService.login(account));
  }
  @PutMapping
  String update(@RequestBody Account a){return accountService.update(a);}
  @DeleteMapping
  String delete(@PathVariable String username){return accountService.delete(username);}
}
