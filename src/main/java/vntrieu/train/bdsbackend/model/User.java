package vntrieu.train.bdsbackend.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {
  @Id
  @SequenceGenerator(
      name = "user_sequence",
      sequenceName = "user_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "user_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
  private Long id;
  @Column(
      name = "name",
      nullable = false
  )
  private String name;
  @Column(
      name = "date_of_birth",
      nullable = false
  )
  private LocalDate dateOfBirth;
  @Column(
      name = "gender",
      nullable = false
  )
  private Boolean gender;
  @Column(
      name = "avt",
      nullable = false
  )
  private String avt;

  public User(Long id, String name, LocalDate dateOfBirth, Boolean gender, String avt) {
    this.id = id;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.avt = avt;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", dateOfBirth=" + dateOfBirth +
        ", gender=" + gender +
        ", avt='" + avt + '\'' +
        '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Boolean getGender() {
    return gender;
  }

  public void setGender(Boolean gender) {
    this.gender = gender;
  }

  public String getAvt() {
    return avt;
  }

  public void setAvt(String avt) {
    this.avt = avt;
  }


}
