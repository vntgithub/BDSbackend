package vntrieu.train.bdsbackend.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Contact {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;


  @OneToOne(fetch = FetchType.LAZY, mappedBy = "contact")
  private User user;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "contact", cascade = CascadeType.ALL)
  private MessageModel messageModel;

}
