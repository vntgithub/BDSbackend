package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
  @Id
  @Column(
      name = "username",
      updatable = false
  )
  private String username;
  @Column(
      name = "password",
      nullable = false
  )
  private String password;

  @OneToOne
  @JoinColumn(name = "u_id")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private  User user;

}
