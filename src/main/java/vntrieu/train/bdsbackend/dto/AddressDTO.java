package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.Address;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDTO {
  private Long id, district_id, ward_id, street_id;
  private Integer province_city_id;
  private String addressString;

  public AddressDTO(Address a){
    this.id = a.getId();
    this.province_city_id = a.getProvinceCity().getId();
    this.district_id = a.getDistrict().getId();
    this.ward_id = a.getWard().getId();
    this.street_id = a.getWard().getId();
    this.addressString = a.getStreet().getName() + " "
        +  a.getWard().getName() + " "
        + a.getDistrict().getName() + " "
        + a.getProvinceCity().getName();
  }
}
