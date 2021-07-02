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
import vntrieu.train.bdsbackend.dto.StreetDTO;
import vntrieu.train.bdsbackend.model.Street;
import vntrieu.train.bdsbackend.service.StreetService;

@AllArgsConstructor
@RestController
@RequestMapping("/street")
public class StreetController {
  private final StreetService streetService;

  @GetMapping("/{ward_id}")
  List<StreetDTO> filter(@PathVariable Long ward_id){
    List<Street> data =  streetService.filterByWardId(ward_id);
    List<StreetDTO> rs = new ArrayList<StreetDTO>();
    for(Street s : data) {
      rs.add(new StreetDTO(s));
    }
    return rs;
  }

  @PostMapping
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  StreetDTO add(@RequestBody Street s) {
    return new StreetDTO(streetService.add(s));
  }

  @PutMapping
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  StreetDTO update(@RequestBody Street s) {
    return new StreetDTO(streetService.update(s));
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  String delete(@PathVariable Long id){
    return streetService.delete(id);
  }
}
