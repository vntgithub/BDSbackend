package vntrieu.train.bdsbackend.model;

import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  @NonNull
  private Long id;

  @ManyToOne
  @JoinColumn(name = "street_id")
  @NonNull
  private Street street;

  @ManyToOne
  @JoinColumn(name = "ward_id")
  @NonNull
  private Ward ward;

  @ManyToOne
  @JoinColumn(name = "district_id")
  @NonNull
  private District district;

  @ManyToOne
  @JoinColumn(name = "province_city_id")
  @NonNull
  private ProvinceCity provinceCity;

  @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
  private User user;

  @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
  private Product product;

}
