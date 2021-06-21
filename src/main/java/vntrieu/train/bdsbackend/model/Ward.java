package vntrieu.train.bdsbackend.model;

import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Ward {
  @Id
  @SequenceGenerator(
      name = "ward_sequence",
      sequenceName = "ward_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "ward_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
  private Long id;
  @Column(
      name = "name",
      nullable = false,
      columnDefinition = "TEXT"
  )
  private String name;
//  @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
//  @EqualsAndHashCode.Exclude
//  @ToString.Exclude
//  private Collection<Address> address;

  @ManyToOne
  @JoinColumn(name = "district_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private District district;

//  @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
//  @EqualsAndHashCode.Exclude
//  @ToString.Exclude
//  private List<Street> streets;
}
