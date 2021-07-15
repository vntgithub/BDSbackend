package vntrieu.train.bdsbackend.model;

import java.util.Collection;
import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Ward {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  @NonNull
  private Long id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  @NonNull
  private String name;


  @ManyToOne
  @JoinColumn(name = "district_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @NonNull
  private District district;

}
