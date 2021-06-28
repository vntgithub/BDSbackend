package vntrieu.train.bdsbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.*;

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
  @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "date_of_birth", nullable = false)
  @JsonFormat(pattern="dd-MM-yyyy")
  private LocalDate dateOfBirth;

  @Column(name = "gender", nullable = false)
  private Boolean gender;

  @Column(name = "avt", nullable = false)
  private String avt;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;

  @OneToOne(mappedBy = "user")
  private Account account;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "contact_id")
  private Contact contact;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Collection<Product> products;

  @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
  private Filter filter;
}
