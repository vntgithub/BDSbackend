package vntrieu.train.bdsbackend.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.dto.DistrictDTO;
import vntrieu.train.bdsbackend.model.District;
import vntrieu.train.bdsbackend.service.DistrictService;

@RestController
@RequestMapping("/district")
@CrossOrigin(origins = "http://localhost:3000/")
public class DistrictController {
  @Autowired
  private  DistrictService districtService;

  @GetMapping("")
  List<DistrictDTO> getAll() {
    List<DistrictDTO> rs  = new ArrayList<DistrictDTO>();
    List<District> data = districtService.getAll();
    for(District i : data){
      rs.add(new DistrictDTO(i));
    }
    return rs;
  }
  @GetMapping("/{p_c_id}")
  List<DistrictDTO> filter(@PathVariable Integer p_c_id) {
    List<District> data =  districtService.filter(p_c_id);
    List<DistrictDTO> rs = new ArrayList<DistrictDTO>();
    for(District i : data) {
      rs.add(new DistrictDTO(i));
    }
    return rs;
  }
  @PostMapping
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  DistrictDTO add(@RequestBody District d) {
    return new DistrictDTO(districtService.add(d));
  }

  @PutMapping
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  DistrictDTO update(@RequestBody District d) {
    return new DistrictDTO(districtService.update(d));
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  String delete(@PathVariable Long id) {
    districtService.delete(id);
    return "Deleted!";
  }
}
