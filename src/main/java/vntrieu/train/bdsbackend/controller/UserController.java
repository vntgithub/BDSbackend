package vntrieu.train.bdsbackend.controller;

import lombok.AllArgsConstructor;
import org.dom4j.util.UserDataAttribute;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vntrieu.train.bdsbackend.dto.UserDTO;
import vntrieu.train.bdsbackend.model.User;
import vntrieu.train.bdsbackend.service.AccountService;
import vntrieu.train.bdsbackend.service.AddressService;
import vntrieu.train.bdsbackend.service.ContactService;
import vntrieu.train.bdsbackend.service.UserService;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService userService;

  @GetMapping("/{id}")
  UserDTO getById(@PathVariable Long id){
    return new UserDTO(userService.getById(id));
  }

  @PutMapping
  UserDTO update(@RequestBody User user) {
    return new UserDTO(userService.update(user));
  }

  @DeleteMapping("/{id}")
  String delete(@PathVariable Long id){
    return userService.delete(id);
  }
}
