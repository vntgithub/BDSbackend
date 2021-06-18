package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Unit {
  @Id
  @SequenceGenerator(
      name = "unit_sequence",
      sequenceName = "unit_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "unit_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
  private Integer id;
  @Column(
      name = "name",
      nullable = false
  )
  private String name;

  @Override
  public String toString() {
    return "Unit{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Unit(Integer id, String name) {
    this.id = id;
    this.name = name;
  }
}
