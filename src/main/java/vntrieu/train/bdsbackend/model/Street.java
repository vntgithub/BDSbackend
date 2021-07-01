package vntrieu.train.bdsbackend.model;

import java.util.Collection;
import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
public class Street {
  @Id
  @SequenceGenerator(name = "street_sequence", sequenceName = "street_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "street_sequence")
  @Column(name = "id", updatable = false)
  @NonNull
  private Long id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  @NonNull
  private String name;

  @OneToMany(mappedBy = "street", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Collection<Address> address;

  @ManyToOne
  @JoinColumn(name = "wards_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @NonNull
  private Ward ward;

}
