package vntrieu.train.bdsbackend.model;

import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Image {
  @Id
  @SequenceGenerator(name = "image_sequence", sequenceName = "image_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_sequence")
  @Column(name = "id", updatable = false)
  @NonNull
  private Long id;

  @Column(name = "url", nullable = false)
  @NonNull
  private String url;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Product product;

}
