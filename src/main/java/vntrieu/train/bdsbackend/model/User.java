package vntrieu.train.bdsbackend.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

//  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//  @EqualsAndHashCode.Exclude
//  @ToString.Exclude
//  private List<Product> products;
}
