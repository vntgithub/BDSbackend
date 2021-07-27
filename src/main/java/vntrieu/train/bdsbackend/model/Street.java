package vntrieu.train.bdsbackend.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Street {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  private String name;

  @ManyToOne
  @JoinColumn(name = "wards_id")
  private Ward ward;

}
