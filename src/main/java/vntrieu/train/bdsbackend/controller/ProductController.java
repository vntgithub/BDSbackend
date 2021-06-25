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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vntrieu.train.bdsbackend.dto.ProductDTO;
import vntrieu.train.bdsbackend.model.Address;
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

  @GetMapping("/search")
  List<ProductDTO> search(@RequestParam
      Integer provinceCityId,
      Long districtId,
      Long wardId,
      Long streetId
  ){

    List<ProductDTO> resData = new ArrayList<ProductDTO>();
    if(streetId != null){
      List<Address> data = addressService.searchByStreet(streetId);
      for(Address a : data){
        if(a.getProduct() != null)
          resData.add(new ProductDTO(a.getProduct()));
      }
      return resData;
    }
    if(wardId != null){
      List<Address> data = addressService.searchByWard(wardId);
      for(Address a : data){
        if(a.getProduct() != null)
          resData.add(new ProductDTO(a.getProduct()));
      }
      return resData;
    }
    if(districtId != null){
      List<Address> data = addressService.searchByDistrict(districtId);
      for(Address a : data){
        if(a.getProduct() != null)
          resData.add(new ProductDTO(a.getProduct()));
      }
      return resData;
    }
    if(provinceCityId != null){
      List<Address> data = addressService.searchByCity(provinceCityId);
      for(Address a : data){
        if(a.getProduct() != null)
          resData.add(new ProductDTO(a.getProduct()));
      }
    }
    return resData;
  }
}
