package vntrieu.train.bdsbackend.model;

import java.util.Collection;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Category {
  @Id
  @SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
  @Column(name = "id", updatable = false)
  @NonNull
  private Integer id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  @NonNull
  private String name;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Collection<Product> products;
}
