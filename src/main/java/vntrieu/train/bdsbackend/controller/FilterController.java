package vntrieu.train.bdsbackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.dto.FilterDTO;
import vntrieu.train.bdsbackend.model.Filter;
import vntrieu.train.bdsbackend.service.FilterService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filter")
@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
public class FilterController {
  private final FilterService filterService;

  @GetMapping("/{id}")
  List<FilterDTO> getByUserId(@PathVariable Long id){
    List<FilterDTO> resData = new ArrayList<FilterDTO>();
    List<Filter> listFilter = filterService.getByUserId(id);
    for(Filter f : listFilter)
      resData.add(new FilterDTO(f));
    return resData;
  }

  @PostMapping
  FilterDTO add(@RequestBody Filter filter){
    System.out.println(filter);
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
