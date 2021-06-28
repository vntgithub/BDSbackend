package vntrieu.train.bdsbackend.model;

import java.util.Collection;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
  @Id
  @SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
  @Column(name = "id", updatable = false)
  private Integer id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  private String name;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Collection<Product> products;
}
