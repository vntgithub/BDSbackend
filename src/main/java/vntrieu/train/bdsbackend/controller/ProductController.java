package vntrieu.train.bdsbackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vntrieu.train.bdsbackend.dto.ProductDTO;
import vntrieu.train.bdsbackend.model.Address;
import vntrieu.train.bdsbackend.model.Filter;
import vntrieu.train.bdsbackend.model.Product;
import vntrieu.train.bdsbackend.service.AddressService;
import vntrieu.train.bdsbackend.service.ProductService;
@RestController
@RequestMapping("/product")
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
                           String priceRange,
                           String searchString
  ){

    List<Product> products = productService.search(provinceCityId, districtId, wardId, streetId, priceRange, searchString);
    List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
    for(Product p : products)
      listProductDTO.add(new ProductDTO(p));

    return listProductDTO;
  }
  @GetMapping("/search/{searchString}")
  List<ProductDTO> searchByTitle(@PathVariable String searchString){
    List<Product> products = productService.searchByTitle(searchString);
    List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
    for(Product p : products)
      productDTOs.add(new ProductDTO(p));

    return productDTOs;
  }
  @GetMapping("/search2")
  List<ProductDTO> search2(
          Integer provinceCityId,
          Long districtId,
          Long wardId,
          Long streetId,
          String searchString
  ){
    List<Product> products =  productService.search1(provinceCityId, districtId, wardId, streetId, searchString);
    List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();
    for(Product p : products)
      productDTOS.add(new ProductDTO(p));

    return productDTOS;
  }
}
