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
  @JoinColumn(name = "str_id")
  private Street street;

  @ManyToOne
  @JoinColumn(name = "w_id")
  private Ward ward;

  @ManyToOne
  @JoinColumn(name = "d_id")
  private District district;

  @ManyToOne
  @JoinColumn(name = "p_id")
  private ProvinceCity provinceCity;

  @OneToOne
  @JoinColumn(name = "u_id")
  private User user;


}
