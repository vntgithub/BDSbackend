package vntrieu.train.bdsbackend.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import vntrieu.train.bdsbackend.model.Image;
import vntrieu.train.bdsbackend.model.Product;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
  private Long id;
  private String tiltle;
  private Boolean lease;
  private Integer price;
  private String descreption;
  private AddressDTO address;
  private CategoryDTO category;
  private List<ImageDTO> images;
  private UnitDTO unit;
  private UserDTO user;

  public ProductDTO(Product p){
    this.id = p.getId();
    this.tiltle = p.getTiltle();
    this.lease = p.getLease();
    this.price = p.getPrice();
    this.descreption = p.getDescreption();
    this.address = new AddressDTO(p.getAddress());
    this.category = new CategoryDTO(p.getCategory());
    Collection<Image> data = p.getImages();
    this.images = new ArrayList<ImageDTO>();
    for(Image item : data){
      this.images.add(new ImageDTO(item));
    }
    this.unit = new UnitDTO(p.getUnit());
    this.user = new UserDTO(p.getUser());
  }
}
