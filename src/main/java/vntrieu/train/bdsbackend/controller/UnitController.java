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
import vntrieu.train.bdsbackend.dto.UnitDTO;
import vntrieu.train.bdsbackend.model.Unit;
import vntrieu.train.bdsbackend.service.UnitService;
@AllArgsConstructor
@RestController
@RequestMapping("/unit")
public class UnitController {
  private final UnitService unitService;

  @GetMapping
  List<UnitDTO> getAll(){
    List<Unit> data = unitService.getAll();
    List<UnitDTO> rs = new ArrayList<UnitDTO>();
    for(Unit u : data)
      rs.add(new UnitDTO(u));
    return rs;
  }

  @PostMapping
  UnitDTO add(@RequestBody Unit u){return new UnitDTO(unitService.add(u));}

  @PutMapping
  UnitDTO update(@RequestBody Unit u){return new UnitDTO(unitService.update(u));}

  @DeleteMapping("/{id}")
  String delete(@PathVariable Integer id){return unitService.delete(id);}
}
