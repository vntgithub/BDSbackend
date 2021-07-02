package vntrieu.train.bdsbackend.model;

import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Account {
  @Id
  @Column(name = "username", updatable = false)
  @NonNull
  private  String username;

  @Column(name = "password", nullable = false)
  @NonNull
  private  String password;

  @ManyToOne
  @JoinColumn(name = "role_id", referencedColumnName = "id")
  @NonNull
  private Role role;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private  User user;

}
