package vntrieu.train.bdsbackend.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
public class Ward {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  private String name;


  @ManyToOne
  @JoinColumn(name = "district_id")
  private District district;

}
