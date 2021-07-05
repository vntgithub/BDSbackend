package vntrieu.train.bdsbackend.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.dto.WardDTO;
import vntrieu.train.bdsbackend.model.Ward;
import vntrieu.train.bdsbackend.service.WardService;

@AllArgsConstructor
@RestController
@RequestMapping("/ward")
@CrossOrigin(origins = "http://localhost:3000/")
public class WardController {
  private final WardService wardService;

  @GetMapping("/{district_id}")
  List<WardDTO> filter(@PathVariable Long district_id){
    List<WardDTO> rs = new ArrayList<WardDTO>();
    List<Ward> data =  wardService.filter(district_id);
    for(Ward i : data) {
      rs.add(new WardDTO(i));
    }
    return rs;
  }

  @PostMapping
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  WardDTO add(@RequestBody Ward w) {
    return new WardDTO(wardService.add(w));
  }

  @PutMapping
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  WardDTO update(@RequestBody Ward w){
    return new WardDTO(wardService.update(w));
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  String delete(@PathVariable Long id) {
    return wardService.delete(id);
  }
}
