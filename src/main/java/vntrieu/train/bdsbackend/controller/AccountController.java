package vntrieu.train.bdsbackend.controller;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vntrieu.train.bdsbackend.JWT.JwtTokenProvider;
import vntrieu.train.bdsbackend.dto.AccountDTO;
import vntrieu.train.bdsbackend.dto.UserDTO;
import vntrieu.train.bdsbackend.model.Account;
import vntrieu.train.bdsbackend.model.AccountDetails;
import vntrieu.train.bdsbackend.model.User;
import vntrieu.train.bdsbackend.service.AccountService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public Map<String, Object> authenticateUser(@RequestBody Account account) {
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
        User user = accountService.getByUsername(account.getUsername());
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("user", new UserDTO(user));
        rs.put("token", jwt);
        return rs;
    }

  @PostMapping
  UserDTO sigin(@RequestBody Account account){return new UserDTO(accountService.add(account));}

  @PutMapping
  String update(@RequestBody Account a){return accountService.update(a);}

  @DeleteMapping
  String delete(@PathVariable String username){return accountService.delete(username);}
}
