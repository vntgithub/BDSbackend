package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.Image;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageDTO {
  private Long id;
  private String url;

  public ImageDTO(Image i){
    this.id = i.getId();
    this.url = i.getUrl();
  }
}
