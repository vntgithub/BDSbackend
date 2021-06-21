package vntrieu.train.bdsbackend.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vntrieu.train.bdsbackend.dto.DistrictDTO;
import vntrieu.train.bdsbackend.model.District;
import vntrieu.train.bdsbackend.service.DistrictService;

@AllArgsConstructor
@RestController
@RequestMapping("/district")
public class DistrictController {
  private final DistrictService districtService;

  @GetMapping("")
  List<DistrictDTO> getAll() {
    List<DistrictDTO> rs  = new ArrayList<DistrictDTO>();
    List<District> data = districtService.getAll();
    for(District i : data){
      rs.add(new DistrictDTO(i));
    }
    return rs;
  }
  @GetMapping("/filter/{p_c_id}")
  List<DistrictDTO> filter(@PathVariable Integer p_c_id) {
    List<District> data =  districtService.filter(p_c_id);
    List<DistrictDTO> rs = new ArrayList<DistrictDTO>();
    for(District i : data) {
      rs.add(new DistrictDTO(i));
    }
    return rs;
  }
  @PostMapping("/add")
  DistrictDTO add(@RequestBody District d) {
    return new DistrictDTO(districtService.add(d));
  }

  @PutMapping("/update")
  DistrictDTO update(@RequestBody District d) {
    return new DistrictDTO(districtService.update(d));
  }
  @DeleteMapping("/delete/{id}")
  String delete(@PathVariable Long id) {
    districtService.delete(id);
    return "Deleted!";
  }
}
