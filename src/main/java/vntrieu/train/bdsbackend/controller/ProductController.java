package vntrieu.train.bdsbackend.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.ExcelExport.ProductExcelExporter;
import vntrieu.train.bdsbackend.dto.ProductDTO;
import vntrieu.train.bdsbackend.model.Product;
import vntrieu.train.bdsbackend.service.ProductService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {
  @Autowired
  private  ProductService productService;

  @GetMapping("/numberofpage")
  Long getNumberOfPage(){return productService.getNumberOfPage();}

  @GetMapping("/detail/{id}")
  ProductDTO getById(@PathVariable Long id){
    return new ProductDTO(productService.getProductById(id));
  }

  @GetMapping("/numberofpage/{userId}")
  Long getNumberOfPage(@PathVariable Long userId){return productService.countPageByUserId(userId);}

  @GetMapping("/page/{index}")
  List<ProductDTO> get(@PathVariable Short index) {
    Pageable page = PageRequest.of(index, 10);
    List<Product> data = productService.getProduct(page);
    List<ProductDTO> dataRes = new ArrayList<ProductDTO>();
    for(Product item : data){
      dataRes.add(new ProductDTO(item));
    }
    return dataRes;
  }

  @GetMapping("/{userId}/{index}")
  List<ProductDTO> getByUserId(@PathVariable Long userId,@PathVariable Integer index){
    Pageable page = PageRequest.of(index, 10);
    List<Product> data = productService.getByUserId(userId, page);
    List<ProductDTO> listProduct = new ArrayList<ProductDTO>();
    for(Product item : data){
      listProduct.add(new ProductDTO(item));
    }

    return listProduct;
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
                           Long priceStart,
                           Long priceEnd,
                           String searchString,
                           Integer index
  ){
    Pageable page = PageRequest.of(index, 10);
    List<Product> products = productService.search(
            provinceCityId,
            districtId,
            wardId,
            streetId,
            priceStart,
            priceEnd,
            searchString,
            page
    );

    List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();

    if(products != null)
      for(Product p : products)
        listProductDTO.add(new ProductDTO(p));

    return listProductDTO;
  }

  @GetMapping (value = "/report")
  ResponseEntity reportExcel  (@RequestParam(required = false)
                               Integer provinceCityId,
                               Long districtId,
                               Long wardId,
                               Long streetId,
                               Long priceStart,
                               Long priceEnd,
                               String searchString,
                               Integer index
  ) throws IOException {
    List<Product> products = productService.search(
            provinceCityId,
            districtId,
            wardId,
            streetId,
            priceStart,
            priceEnd,
            searchString,
            null
    );

    List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();

    if(products != null)
      for(Product p : products)
        listProductDTO.add(new ProductDTO(p));

    ProductExcelExporter excelExporter = new ProductExcelExporter(listProductDTO);

    ByteArrayInputStream in = excelExporter.export();
    // return IOUtils.toByteArray(in);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "attachment; filename=product.xlsx");

    return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
  }

}
