package vntrieu.train.bdsbackend.model;

import java.util.Collection;
import javax.persistence.*;

import lombok.*;

@Entity(name = "province_city")
@Data
public class ProvinceCity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Integer id;

  @Column(name = "name", nullable = false, columnDefinition = "TEXT")
  private String name;

}
