package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.Street;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StreetDTO {
  private Long id;
  private String name;

  public StreetDTO(Street street) {
    this.id = street.getId();
    this.name = street.getName();
  }

}
