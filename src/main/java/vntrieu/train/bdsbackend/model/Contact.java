package vntrieu.train.bdsbackend.model;

import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Contact {
  @Id
  @SequenceGenerator(name = "contact_sequence", sequenceName = "contact_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_sequence")
  @Column(name = "id", updatable = false)
  @NonNull
  private Long id;

  @Column(name = "email", nullable = false)
  @NonNull
  private String email;

  @Column(name = "phone_number", nullable = false)
  @NonNull
  private String phoneNumber;


  @OneToOne(mappedBy = "contact", fetch = FetchType.LAZY)
  private User user;

}
