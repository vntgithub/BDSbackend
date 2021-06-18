package vntrieu.train.bdsbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ProviteCity {
  @Id
  @SequenceGenerator(
      name = "provitecity_sequence",
      sequenceName = "provitecity_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "provitecity_sequence"
  )
  @Column(
      name = "id",
      updatable = false
  )
  private Integer id;
  @Column(
      name = "name",
      nullable = false,
      columnDefinition = "TEXT"
  )
  private String name;

  public ProviteCity(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "ProviteCity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
