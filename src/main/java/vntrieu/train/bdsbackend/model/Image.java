package vntrieu.train.bdsbackend.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "url", nullable = false)
  private String url;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;

}
