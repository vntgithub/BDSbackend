package vntrieu.train.bdsbackend.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.dto.CategoryDTO;
import vntrieu.train.bdsbackend.model.Category;
import vntrieu.train.bdsbackend.service.CategoryService;
@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
public class CategoryController {
  private final CategoryService categoryService;

  @GetMapping
  List<CategoryDTO> getALl(){
    List<Category> data = categoryService.getAll();
    List<CategoryDTO> rs = new ArrayList<CategoryDTO>();
    for(Category i : data){
      rs.add(new CategoryDTO(i));
    }
    return rs;
  }

  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  @PostMapping
  CategoryDTO add(@RequestBody Category c){return new CategoryDTO(categoryService.add(c));}

  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  @PutMapping
  CategoryDTO update(@RequestBody Category c){return new CategoryDTO(categoryService.update(c));}

  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  @DeleteMapping("/{id}")
  String delete(@PathVariable Integer id){return categoryService.delete(id);}
}
