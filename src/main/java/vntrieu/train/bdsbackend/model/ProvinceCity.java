package vntrieu.train.bdsbackend.model;

import java.util.Collection;
import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name = "province_city")
public class ProvinceCity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  @NonNull
  private Integer id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  @NonNull
  private String name;


}
