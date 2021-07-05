package vntrieu.train.bdsbackend.controller;

import lombok.AllArgsConstructor;
import org.dom4j.util.UserDataAttribute;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.dto.UserDTO;
import vntrieu.train.bdsbackend.model.User;
import vntrieu.train.bdsbackend.service.AccountService;
import vntrieu.train.bdsbackend.service.AddressService;
import vntrieu.train.bdsbackend.service.ContactService;
import vntrieu.train.bdsbackend.service.UserService;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000/")
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
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  String delete(@PathVariable Long id){
    return userService.delete(id);
  }
}
