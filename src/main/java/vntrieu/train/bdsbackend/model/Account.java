package vntrieu.train.bdsbackend.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Account {
  @Id
  @Column(name = "username", updatable = false)
  private  String username;

  @Column(name = "password", nullable = false)
  private  String password;

  @ManyToOne
  @JoinColumn(name = "role_id", referencedColumnName = "id")
  private Role role;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private  User user;

}
