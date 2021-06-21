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
public class District {
  @Id
  @SequenceGenerator(
      name = "district_sequence",
      sequenceName = "district_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "district_sequence"
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

//  @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
//  @EqualsAndHashCode.Exclude
//  @ToString.Exclude
//  private Collection<Address> address;

  @ManyToOne
  @JoinColumn(name = "p_c_id")
  @EqualsAndHashCode.Exclude
  private ProvinceCity provinceCity;

//  @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
//  @EqualsAndHashCode.Exclude
//  @ToString.Exclude
//  private List<Ward> wards;

}
