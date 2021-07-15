package vntrieu.train.bdsbackend.model;

import java.util.Collection;
import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class District {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  private String name;


  @ManyToOne
  @JoinColumn(name = "p_c_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private ProvinceCity provinceCity;


}
