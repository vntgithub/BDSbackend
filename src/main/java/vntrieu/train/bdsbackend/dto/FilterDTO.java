package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.Filter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilterDTO {
  private Long id;
  private ProvinceCityDTO provinceCity;
  private DistrictDTO district;
  private WardDTO ward;
  private StreetDTO street;

  public FilterDTO(Filter filter){
    this.id = filter.getId();
    this.provinceCity = new ProvinceCityDTO(filter.getProvinceCity());
    this.district = new DistrictDTO(filter.getDistrict());
    this.ward = new WardDTO(filter.getWard());
    this.street = new StreetDTO(filter.getStreet());
  }
}
