package vntrieu.train.bdsbackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vntrieu.train.bdsbackend.dto.FilterDTO;
import vntrieu.train.bdsbackend.model.Filter;
import vntrieu.train.bdsbackend.service.FilterService;

@RestController
@RequestMapping("/filter")
@AllArgsConstructor
public class FilterController {
  private final FilterService filterService;

  @GetMapping("/{id}")
  FilterDTO getById(@PathVariable Long id){
    return new FilterDTO(filterService.getByUserId(id));
  }

  @PostMapping
  FilterDTO add(@RequestBody Filter filter){
    return new FilterDTO(filterService.add(filter));
  }

  @PutMapping
  FilterDTO update(@RequestBody Filter filter){
    Filter rs = filterService.update(filter);
    if(rs != null)
      return new FilterDTO(rs);
    return null;
  }
}
