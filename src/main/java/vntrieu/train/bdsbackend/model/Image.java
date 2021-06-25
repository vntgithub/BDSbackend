package vntrieu.train.bdsbackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "product_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Product product;

}
