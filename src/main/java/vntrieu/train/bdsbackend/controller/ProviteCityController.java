package vntrieu.train.bdsbackend.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.dto.ProvinceCityDTO;
import vntrieu.train.bdsbackend.model.ProvinceCity;
import vntrieu.train.bdsbackend.service.ProvinceCityService;

@RestController
@RequestMapping("/province_city")
@CrossOrigin(origins = "http://localhost:3000/")
public class ProviteCityController {

  @Autowired
  private  ProvinceCityService provinceCityServiceervice;

  @GetMapping("")
  List<ProvinceCityDTO> getAll(){
    List<ProvinceCity> data = provinceCityServiceervice.getAll();
    List<ProvinceCityDTO> rs = new ArrayList<ProvinceCityDTO>();
    for(ProvinceCity i : data){
      rs.add(new ProvinceCityDTO(i));
    }
    return rs;
  }
  @PostMapping
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  ProvinceCityDTO add(@RequestBody ProvinceCity newProvinceCity){
    return new ProvinceCityDTO(provinceCityServiceervice.add(newProvinceCity));
  }

  @PutMapping
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  ProvinceCityDTO update(@RequestBody ProvinceCity p) {
    return new ProvinceCityDTO(provinceCityServiceervice.update(p));
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  void delete (@PathVariable Integer id){
    provinceCityServiceervice.delete(id);
  }

}
