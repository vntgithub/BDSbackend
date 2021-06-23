package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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
  private String phoneNumber;


  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;
}
