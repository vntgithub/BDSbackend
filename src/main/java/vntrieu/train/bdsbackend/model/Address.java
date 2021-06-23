package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
  @Id
  @SequenceGenerator(
      name = "address_sequence",
      sequenceName = "address_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "address_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
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

  @OneToOne
  @JoinColumn(name = "user_id", nullable = true)
  private User user;

  @OneToOne
  @JoinColumn(name = "product_id", nullable = true)
  private Product product;


}
