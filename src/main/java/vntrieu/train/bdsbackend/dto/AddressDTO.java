package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.Address;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDTO {
  private Long id;
  private ProvinceCityDTO provinceCity;
  private DistrictDTO district;
  private WardDTO ward;
  private StreetDTO street;
  private String addressString;

  public AddressDTO(Address a){
    this.id = a.getId();
    this.provinceCity = new ProvinceCityDTO(a.getProvinceCity());
    this.district = new DistrictDTO(a.getDistrict());
    this.ward = new WardDTO(a.getWard());
    this.street = new StreetDTO(a.getStreet());
    this.addressString = a.getStreet().getName() + " "
        +  a.getWard().getName() + " "
        + a.getDistrict().getName() + " "
        + a.getProvinceCity().getName();
  }
}
