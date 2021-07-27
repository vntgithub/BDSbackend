package vntrieu.train.bdsbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity(name = "person")
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;


  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "contact_id", referencedColumnName = "id")
  private Contact contact;

  @OneToMany(mappedBy = "user")
  private List<Notification> notificationList;

  @OneToMany(mappedBy = "user")
  private List<Contract> contracts;

}
