package vntrieu.train.bdsbackend.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vntrieu.train.bdsbackend.dto.WardDTO;
import vntrieu.train.bdsbackend.model.Ward;
import vntrieu.train.bdsbackend.service.WardService;

@AllArgsConstructor
@RestController
@RequestMapping("/ward")
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
