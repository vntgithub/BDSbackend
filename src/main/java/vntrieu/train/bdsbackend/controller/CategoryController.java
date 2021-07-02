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
import vntrieu.train.bdsbackend.dto.CategoryDTO;
import vntrieu.train.bdsbackend.model.Category;
import vntrieu.train.bdsbackend.service.CategoryService;
@RestController
@RequestMapping("/category")
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

  @PutMapping
  CategoryDTO update(@RequestBody Category c){return new CategoryDTO(categoryService.update(c));}

  @DeleteMapping("/{id}")
  String delete(@PathVariable Integer id){return categoryService.delete(id);}
}
