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
  @SequenceGenerator(name = "ward_sequence", sequenceName = "ward_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ward_sequence")
  @Column(name = "id", updatable = false)
  @NonNull
  private Long id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  @NonNull
  private String name;

  @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Collection<Address> address;

  @ManyToOne
  @JoinColumn(name = "district_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @NonNull
  private District district;

  @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Collection<Street> streets;

}
