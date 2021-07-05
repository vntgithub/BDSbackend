package vntrieu.train.bdsbackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.dto.ProductDTO;
import vntrieu.train.bdsbackend.model.Address;
import vntrieu.train.bdsbackend.model.Filter;
import vntrieu.train.bdsbackend.model.Product;
import vntrieu.train.bdsbackend.service.AddressService;
import vntrieu.train.bdsbackend.service.ProductService;
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
public class ProductController {
  private final ProductService productService;
  private final AddressService addressService;

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
