package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
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
  @Column(
      name = "user_id",
      nullable = false
  )
  private  Long userId;

  public Account(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public String toString() {
    return "Account{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        '}';
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
