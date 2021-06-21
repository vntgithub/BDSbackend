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
import vntrieu.train.bdsbackend.dto.ProvinceCityDTO;
import vntrieu.train.bdsbackend.model.ProvinceCity;
import vntrieu.train.bdsbackend.service.ProvinceCityService;

@AllArgsConstructor
@RestController
@RequestMapping("/province_city")
public class ProviteCityController {
  private final ProvinceCityService provinceCityServiceervice;

  @GetMapping("")
  List<ProvinceCityDTO> getAll(){
    List<ProvinceCity> data = provinceCityServiceervice.getAll();
    List<ProvinceCityDTO> rs = new ArrayList<ProvinceCityDTO>();
    for(ProvinceCity i : data){
      rs.add(new ProvinceCityDTO(i));
    }
    return rs;
  }
  @PostMapping("/add")
  ProvinceCity add(@RequestBody ProvinceCity newProvinceCity){
    return provinceCityServiceervice.add(newProvinceCity);
  }

  @PutMapping("/update")
  ProvinceCity update(@RequestBody ProvinceCity p) {
    return provinceCityServiceervice.update(p);
  }

  @DeleteMapping("/delete/{id}")
  void delete (@PathVariable Integer id){
    provinceCityServiceervice.delete(id);
  }

}
