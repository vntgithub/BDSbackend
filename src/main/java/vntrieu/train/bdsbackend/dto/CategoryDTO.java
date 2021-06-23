package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.Category;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {
  private Integer id;
  private String name;

  public CategoryDTO(Category c){
    this.id = c.getId();
    this.name = c.getName();
  }
}
