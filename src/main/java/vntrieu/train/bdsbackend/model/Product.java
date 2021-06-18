package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {
  @Id
  @SequenceGenerator(
      name = "product_sequence",
      sequenceName = "product_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "product_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
  private Long id;
  @Column(
      name = "title",
      nullable = false
  )
  private String tiltle;
  @Column(
      name = "lease",
      nullable = false
  )
  private Boolean lease;
  @Column(
      name = "price",
      nullable = false
  )
  private Integer price;
  @Column(
      name = "descreption",
      nullable = false
  )
  private String descreption;
  @Column(
      name = "address_id",
      nullable = false
  )
  private Long addressId;
  @Column(
      name = "category_id",
      nullable = false,
      updatable = false
  )
  private Integer categoryId;

  public Product() {
  }

  public Product(Long id, String tiltle, Boolean lease, Integer price, String descreption,
      Long addressId, Integer categoryId) {
    this.id = id;
    this.tiltle = tiltle;
    this.lease = lease;
    this.price = price;
    this.descreption = descreption;
    this.addressId = addressId;
    this.categoryId = categoryId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTiltle() {
    return tiltle;
  }

  public void setTiltle(String tiltle) {
    this.tiltle = tiltle;
  }

  public Boolean getLease() {
    return lease;
  }

  public void setLease(Boolean lease) {
    this.lease = lease;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getDescreption() {
    return descreption;
  }

  public void setDescreption(String descreption) {
    this.descreption = descreption;
  }

  public Long getAddressId() {
    return addressId;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", tiltle='" + tiltle + '\'' +
        ", lease=" + lease +
        ", price=" + price +
        ", descreption='" + descreption + '\'' +
        ", addressId=" + addressId +
        ", categoryId=" + categoryId +
        '}';
  }
}
