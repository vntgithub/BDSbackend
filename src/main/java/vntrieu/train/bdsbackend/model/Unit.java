package vntrieu.train.bdsbackend.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Unit {
  @Id
  @SequenceGenerator(
      name = "unit_sequence",
      sequenceName = "unit_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "unit_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
  private Integer id;
  @Column(
      name = "name",
      nullable = false
  )
  private String name;

//  @OneToMany(mappedBy = "unit", cascade = CascadeType.ALL)
//  @EqualsAndHashCode.Exclude
//  @ToString.Exclude
//  private Collection<Product> products;
}
