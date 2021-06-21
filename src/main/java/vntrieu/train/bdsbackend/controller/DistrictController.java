package vntrieu.train.bdsbackend.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vntrieu.train.bdsbackend.dto.DistrictDTO;
import vntrieu.train.bdsbackend.model.District;
import vntrieu.train.bdsbackend.service.DistrictService;

@AllArgsConstructor
@RestController
@RequestMapping(name = "/district")
public class DistrictController {
  private final DistrictService service;

  @GetMapping("")
  List<DistrictDTO> getAll() {
    List<DistrictDTO> rs  = new ArrayList<DistrictDTO>();
    List<District> data = service.getAll();
    for(District i : data){
      rs.add(new DistrictDTO(i));
    }
    return rs;
  }
  @PostMapping("/add")
  DistrictDTO add(@RequestBody District d) {
    return new DistrictDTO(service.add(d));
  }
}
