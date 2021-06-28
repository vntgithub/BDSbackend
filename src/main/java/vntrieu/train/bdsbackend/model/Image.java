package vntrieu.train.bdsbackend.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Image {
  @Id
  @SequenceGenerator(name = "image_sequence", sequenceName = "image_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_sequence")
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "url", nullable = false)
  private String url;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Product product;

}
