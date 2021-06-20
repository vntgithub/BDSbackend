package vntrieu.train.bdsbackend.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Detail implements Serializable {
  @Id
  @OneToOne
  @JoinColumn(name ="product_id", updatable = false, insertable = false)
  private Product product;
  @Column(
      name = "frontispiece",
      nullable = false
  )
  private Integer frontispiece;
  @Column(
      name = "number_of_floors",
      nullable = false
  )
  private Short numberOfFloors;
  @Column(
      name = "number_of_wc",
      nullable = false
  )
  private Short numberOfWC;
  @Column(
      name = "funiture",
      nullable = false
  )
  private String funiture;
  @Column(
      name = "legal_infor",
      nullable = false
  )
  private String legalInfor;



}
