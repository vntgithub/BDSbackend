package vntrieu.train.bdsbackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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


  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private  User user;

}
