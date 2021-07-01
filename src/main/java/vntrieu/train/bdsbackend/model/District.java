package vntrieu.train.bdsbackend.model;

import java.util.Collection;
import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class District {
  @Id
  @SequenceGenerator(name = "district_sequence", sequenceName = "district_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "district_sequence")
  @Column(name = "id", updatable = false)
  @NonNull
  private Long id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  @NonNull
  private String name;

  @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Collection<Address> address;

  @ManyToOne
  @JoinColumn(name = "p_c_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @NonNull
  private ProvinceCity provinceCity;

  @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @NonNull
  private Collection<Ward> wards;

}
