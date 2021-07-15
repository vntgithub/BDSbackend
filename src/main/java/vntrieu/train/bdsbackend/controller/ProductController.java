package vntrieu.train.bdsbackend.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.dto.ProductDTO;
import vntrieu.train.bdsbackend.model.Product;
import vntrieu.train.bdsbackend.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
public class ProductController {
  private final ProductService productService;

  @GetMapping("/numberofpage")
  Long getNumberOfPage(){return productService.getNumberOfPage();}

  @GetMapping("/page/{index}")
  List<ProductDTO> get(@PathVariable Short index) {
    Pageable page = PageRequest.of(index, 8);
    List<Product> data = productService.getProduct(page);
    List<ProductDTO> dataRes = new ArrayList<ProductDTO>();
    for(Product item : data){
      dataRes.add(new ProductDTO(item));
    }
    return dataRes;
  }

  @GetMapping("/{userId}")
  List<ProductDTO> getByUserId(@PathVariable Long userId){
    List<Product> data = productService.getByUserId(userId);
    List<ProductDTO> dataRes = new ArrayList<ProductDTO>();
    for(Product item : data){
      dataRes.add(new ProductDTO(item));
    }
    return dataRes;
  }

  @PostMapping
  ProductDTO  add(@RequestBody Product p){
    return new ProductDTO(productService.add(p));
  }

  @PutMapping
  ProductDTO update(@RequestBody Product p){
    return new ProductDTO(productService.update(p));
  }

  @DeleteMapping("/{id}")
  String delete(@PathVariable Long id){
    return productService.delete(id);
  }

  @GetMapping (value = "/search")
  List<ProductDTO> search (@RequestParam(required = false)
                           Integer provinceCityId,
                           Long districtId,
                           Long wardId,
                           Long streetId,
                           Integer priceRange,
                           String searchString
  ){

    List<Product> products = productService.search(
            provinceCityId,
            districtId,
            wardId,
            streetId,
            priceRange,
            searchString);

    List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();

    if(products != null)
      for(Product p : products)
        listProductDTO.add(new ProductDTO(p));

    return listProductDTO;
  }
}
