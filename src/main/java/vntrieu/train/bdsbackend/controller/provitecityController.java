package vntrieu.train.bdsbackend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vntrieu.train.bdsbackend.model.ProviteCity;
import vntrieu.train.bdsbackend.service.ProviceCityService;


@RestController
@RequestMapping("/provicecity")
public class provitecityController {
  private final ProviceCityService service;

  public provitecityController(ProviceCityService service) {
    this.service = service;
  }
  @GetMapping("/getall")
  List<ProviteCity> getAll(){
    return service.getAll();
  }
  @PostMapping("/add")
  ProviteCity add(ProviteCity newProviteCity){
    return service.add(newProviteCity);
  }

}
