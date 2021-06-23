package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.Unit;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UnitDTO {
  private Integer id;
  private String name;

  public UnitDTO(Unit u){
    this.id = u.getId();
    this.name = u.getName();
  }
}
