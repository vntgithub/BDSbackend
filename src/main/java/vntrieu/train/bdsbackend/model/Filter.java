package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filter {
  @Id
  @SequenceGenerator(name = "filter_sequence", sequenceName = "filter_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filter_sequence")
  @Column(name = "id", updatable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "provinceCity_id")
  private ProvinceCity provinceCity;

  @ManyToOne
  @JoinColumn(name = "district_id")
  private District district;

  @ManyToOne
  @JoinColumn(name = "ward_id")
  private Ward ward;

  @ManyToOne
  @JoinColumn(name = "street_id")
  private Street street;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
