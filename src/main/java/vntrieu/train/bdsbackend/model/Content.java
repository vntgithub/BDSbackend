package vntrieu.train.bdsbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.dto.DistrictDTO;
import vntrieu.train.bdsbackend.dto.ProvinceCityDTO;
import vntrieu.train.bdsbackend.dto.StreetDTO;
import vntrieu.train.bdsbackend.dto.WardDTO;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Content implements Serializable {
    private String search;
    private Short priceRange;
    private Object provinceCity;
    private Object district;
    private Object ward;
    private Object street;
    private Boolean lease;
}
