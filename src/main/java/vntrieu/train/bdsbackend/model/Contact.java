package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Contact {
  @Id
  @SequenceGenerator(
      name = "contact_sequence",
      sequenceName = "contact_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "contact_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
  private Long id;
  @Column(
      name = "email",
      nullable = false
  )
  private String email;
  @Column(
      name = "phone_number",
      nullable = false
  )
  private String phonenumber;
  @Column(
      name = "user_id",
      nullable = false,
      updatable = false
  )
  private Long userId;

  public Contact(Long id, String email, String phonenumber, Long userId) {
    this.id = id;
    this.email = email;
    this.phonenumber = phonenumber;
    this.userId = userId;
  }
  @Override
  public String toString() {
    return "Contact{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", phonenumber='" + phonenumber + '\'' +
        ", userId=" + userId +
        '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

}
