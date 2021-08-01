package vntrieu.train.bdsbackend.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import vntrieu.train.bdsbackend.model.Image;
import vntrieu.train.bdsbackend.model.Product;

import javax.persistence.Column;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
  private Long id;
  private String title;
  private Boolean lease;
  private Long price;
  private String descreption;
  private AddressDTO address;
  private CategoryDTO category;
  private List<ImageDTO> images;
  private String phoneNumber;
  private Integer frontispiece;
  private Short numberOfFloors;
  private Short numberOfWC;
  private String funiture;
  private String legalInfor;
  private  Boolean hasContract;

  public ProductDTO(Product p){
    this.id = p.getId();
    this.title = p.getTitle();
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
    this.phoneNumber = p.getPhoneNumber();
    this.frontispiece = p.getFrontispiece();
    this.numberOfFloors = p.getNumberOfFloors();
    this.numberOfWC = p.getNumberOfWC();
    this.funiture = p.getFuniture();
    this.legalInfor = p.getLegalInfor();
    if(p.getContract() != null)
      this.hasContract = true;
    else
      this.hasContract = false;
  }
}
