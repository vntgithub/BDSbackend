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
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "lease", nullable = false)
  private Boolean lease;

  @Column(name = "price", nullable = false)
  private Long price;

  @Column(name = "descreption", nullable = false)
  private String descreption;

  @Column(name = "phone_number", nullable = false)
  private  String phoneNumber;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;


  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @OneToMany(mappedBy = "product")
  private Collection<Image> images;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "frontispiece",nullable = false)
  private Integer frontispiece;

  @Column(name = "number_of_floors", nullable = false)
  private Short numberOfFloors;

  @Column(name = "number_of_wc", nullable = false)
  private Short numberOfWC;

  @Column(name = "funiture", nullable = false)
  private String funiture;

  @Column(name = "legal_infor", nullable = false)
  private String legalInfor;

}
