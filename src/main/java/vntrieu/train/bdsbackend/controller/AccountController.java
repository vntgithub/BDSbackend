package vntrieu.train.bdsbackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.JWT.JwtTokenProvider;
import vntrieu.train.bdsbackend.dto.UserDTO;
import vntrieu.train.bdsbackend.model.Account;
import vntrieu.train.bdsbackend.model.AccountDetails;
import vntrieu.train.bdsbackend.model.Role;
import vntrieu.train.bdsbackend.model.User;
import vntrieu.train.bdsbackend.service.AccountService;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/account")

public class AccountController {

    @Autowired
    private  AccountService accountService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public Map<String, Object> authenticateUser(@RequestBody Account account, HttpServletRequest request) {
        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        account.getUsername(),
                        account.getPassword()
                )
        );
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((AccountDetails) authentication.getPrincipal());
        String roleName = accountService.getRoleName(account.getUsername());
        User user = accountService.getByUsername(account.getUsername());
        Map<String, Object> rs = new HashMap<String, Object>();
        UserDTO userDTO = new UserDTO(user);
        userDTO.setRole(roleName);
        rs.put("user", userDTO);
        rs.put("token", jwt);
        return rs;
    }

  @GetMapping
  UserDTO loginBytoken(HttpServletRequest request){
      String username = request.getUserPrincipal().getName();
      UserDTO userDTO = new UserDTO(accountService.getByUsername(username));
      String roleName = accountService.getRoleName(username);
      userDTO.setRole(roleName);
      return userDTO;
    }

  @PostMapping
  UserDTO signup(@RequestBody Account account){return new UserDTO(accountService.add(account));}

  @PutMapping
  String update(@RequestBody Account a){return accountService.update(a);}

  @DeleteMapping("/{username}")
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  String delete(@PathVariable String username){return accountService.delete(username);}
}
