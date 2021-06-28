package vntrieu.train.bdsbackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.dto.FilterDTO;
import vntrieu.train.bdsbackend.model.Filter;
import vntrieu.train.bdsbackend.service.FilterService;

@RestController
@RequestMapping("/filter")
@AllArgsConstructor
public class FilterController {
  private final FilterService filterService;

  @GetMapping("/{id}")
  FilterDTO getByUserId(@PathVariable Long id){
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
