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
  @SequenceGenerator(name = "provitecity_sequence", sequenceName = "provincecity_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provincecity_sequence")
  @Column(name = "id", updatable = false)
  @NonNull
  private Integer id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  @NonNull
  private String name;

  @OneToMany(mappedBy = "provinceCity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Collection<Address> address;

  @OneToMany(mappedBy = "provinceCity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Collection<District> districts;

}
