package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.Ward;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WardDTO {
  private Long id;
  private String name;

  public WardDTO(Ward w) {
    this.id = w.getId();
    this.name = w.getName();
  }
}
