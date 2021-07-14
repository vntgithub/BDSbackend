package vntrieu.train.bdsbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Content implements Serializable {
    private String searchString;
    private Short priceRange;
    private Integer provinceCityId;
    private Long districtId;
    private Long wardId;
    private Long streetId;
    private Boolean lease;
}
