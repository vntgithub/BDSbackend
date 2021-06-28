package vntrieu.train.bdsbackend.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
  @Id
  @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
  @Column(name = "id", updatable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "street_id")
  private Street street;

  @ManyToOne
  @JoinColumn(name = "ward_id")
  private Ward ward;

  @ManyToOne
  @JoinColumn(name = "district_id")
  private District district;

  @ManyToOne
  @JoinColumn(name = "province_city_id")
  private ProvinceCity provinceCity;

  @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
  private User user;

  @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
  private Product product;

}
