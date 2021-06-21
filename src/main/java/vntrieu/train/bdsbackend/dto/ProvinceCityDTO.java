package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import vntrieu.train.bdsbackend.model.ProvinceCity;

@AllArgsConstructor
@Data
public class ProvinceCityDTO {
  private Integer id;
  private String name;

  public ProvinceCityDTO(ProvinceCity p) {
    this.id = p.getId();
    this.name = p.getName();
  }
}
