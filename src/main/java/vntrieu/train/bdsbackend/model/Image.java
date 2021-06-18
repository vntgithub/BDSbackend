package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Image {
  @Id
  @SequenceGenerator(
      name = "image_sequence",
      sequenceName = "image_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "image_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
  private Long id;
  @Column(
      name = "url",
      nullable = false
  )
  private String url;
  @Column(
      name = "user_id",
      updatable = false,
      nullable = false
  )
  private Long productId;

  @Override
  public String toString() {
    return "Image{" +
        "id=" + id +
        ", url='" + url + '\'' +
        ", productId=" + productId +
        '}';
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Image(Long id, String url, Long productId) {
    this.id = id;
    this.url = url;
    this.productId = productId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
