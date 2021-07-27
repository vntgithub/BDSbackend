package vntrieu.train.bdsbackend.controller;

import lombok.AllArgsConstructor;
import org.dom4j.util.UserDataAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.dto.UserDTO;
import vntrieu.train.bdsbackend.model.User;
import vntrieu.train.bdsbackend.service.AccountService;
import vntrieu.train.bdsbackend.service.AddressService;
import vntrieu.train.bdsbackend.service.ContactService;
import vntrieu.train.bdsbackend.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
  @Autowired
  private  UserService userService;

  @GetMapping("/{id}")
  UserDTO getById(@PathVariable Long id){
    return new UserDTO(userService.getById(id));
  }

  @GetMapping("/page/{page}")
  List<UserDTO> getPage(@PathVariable Integer index){
    Pageable page = PageRequest.of(index, 10);
    List<User> list = userService.getByPage(page);
    List<UserDTO> rs = new ArrayList<UserDTO>();
    for(User u : list)
      rs.add(new UserDTO(u));
    return rs;
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
