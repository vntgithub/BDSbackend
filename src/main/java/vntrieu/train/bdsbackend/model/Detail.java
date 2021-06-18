package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder.In;
@Entity
public class Detail {
  @Id
  @Column(
      name = "product_id",
      updatable = false
  )
  private Long productId;
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


  public Detail(Long productId, Integer frontispiece, Short numberOfFloors,
      Short numberOfWC, String funiture, String legalInfor) {
    this.productId = productId;
    this.frontispiece = frontispiece;
    this.numberOfFloors = numberOfFloors;
    this.numberOfWC = numberOfWC;
    this.funiture = funiture;
    this.legalInfor = legalInfor;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Integer getFrontispiece() {
    return frontispiece;
  }

  public void setFrontispiece(Integer frontispiece) {
    this.frontispiece = frontispiece;
  }

  public Short getNumberOfFloors() {
    return numberOfFloors;
  }

  public void setNumberOfFloors(Short numberOfFloors) {
    this.numberOfFloors = numberOfFloors;
  }

  public Short getNumberOfWC() {
    return numberOfWC;
  }

  public void setNumberOfWC(Short numberOfWC) {
    this.numberOfWC = numberOfWC;
  }

  public String getFuniture() {
    return funiture;
  }

  public void setFuniture(String funiture) {
    this.funiture = funiture;
  }

  public String getLegalInfor() {
    return legalInfor;
  }

  public void setLegalInfor(String legalInfor) {
    this.legalInfor = legalInfor;
  }

  @Override
  public String toString() {
    return "Detail{" +
        "productId=" + productId +
        ", frontispiece=" + frontispiece +
        ", numberOfFloors=" + numberOfFloors +
        ", numberOfWC=" + numberOfWC +
        ", funiture='" + funiture + '\'' +
        ", legalInfor='" + legalInfor + '\'' +
        '}';
  }
}
