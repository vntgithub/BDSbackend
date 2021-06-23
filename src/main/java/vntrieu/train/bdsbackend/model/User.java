package vntrieu.train.bdsbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "person")
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
  @JsonFormat(pattern="dd-MM-yyyy")
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

  @OneToOne
  @JoinColumn(name = "address_id", nullable = true)
  private Address address;

  @OneToOne
  @JoinColumn(name = "account", nullable = true)
  private Account account;

  @OneToOne
  @JoinColumn(name = "contact_id", nullable = true)
  private Contact contact;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private List<Product> products;
}
