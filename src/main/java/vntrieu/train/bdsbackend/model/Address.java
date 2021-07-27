package vntrieu.train.bdsbackend.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
