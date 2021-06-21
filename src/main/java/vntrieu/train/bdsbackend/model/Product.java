package vntrieu.train.bdsbackend.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

  @OneToOne
  @JoinColumn(name = "address_id")
  private Address address;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

//  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//  @EqualsAndHashCode.Exclude
//  @ToString.Exclude
//  private Collection<Image> images;

  @ManyToOne
  @JoinColumn(name = "unit_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Unit unit;

  @ManyToOne
  @JoinColumn(name = "u_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private User user;

}
