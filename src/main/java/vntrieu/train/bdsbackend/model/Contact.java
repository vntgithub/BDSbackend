package vntrieu.train.bdsbackend.model;

import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Contact {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
