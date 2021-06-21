package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.District;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DistrictDTO {
  private Long id;
  private String name;

  public DistrictDTO(District d) {
    this.id = d.getId();
    this. name = d.getName();
  }
}
