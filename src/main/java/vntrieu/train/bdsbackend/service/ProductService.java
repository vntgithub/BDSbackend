package vntrieu.train.bdsbackend.service;

import java.util.*;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;;
import vntrieu.train.bdsbackend.model.*;
import vntrieu.train.bdsbackend.repository.AddressRepository;
import vntrieu.train.bdsbackend.repository.ImageRepository;
import vntrieu.train.bdsbackend.repository.ProductRepository;
@Service
@AllArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final ImageRepository imageRepository;
  private final AddressRepository addressRepository;

  public List<Product> getByUserId(Long userId){
    return productRepository.getByUserId(userId);
  }

  public Product add(Product p){

    Product newProduct =  productRepository.save(p);
    Collection<Image> listImage =  newProduct.getImages();
    for(Image i : listImage){
      i.setProduct(newProduct);
      imageRepository.save(i);
    }
    return newProduct;
  }

  public Product update(Product p){
    if(productRepository.existsById(p.getId())){
      return productRepository.save(p);
    }
    return new Product();
  }

  public String delete(Long id){
    productRepository.deleteById(id);
    return "Deleted!";
  }

  public static List<Product> filterByPriceRange(List<Product> products, String priceRange){
    List<Product> productsAfterFiltered = new ArrayList<Product>();
    switch (priceRange){
      case "<500":
        for(Product p : products)
          if(p.getPrice() < 500000000)
            productsAfterFiltered.add(p);
      case "500-10000":
        for(Product p : products)
          if(p.getPrice() >= 500000000 && p.getPrice() < 1000000000)
            productsAfterFiltered.add(p);
      case "1000-2000":
        for(Product p : products)
          if(p.getPrice() >= 1000000000 && p.getPrice() < 2000000000)
            productsAfterFiltered.add(p);
      default:
        for(Product p : products)
          if(p.getPrice() > 2000000000)
            productsAfterFiltered.add(p);

    }
    return productsAfterFiltered;
  }
  public static List<Product> filterBySearchSTring(List<Product> products, String searchString){
    Pattern regex = Pattern.compile("^."+searchString+".$");
    List<Product> productsAfterFiltered = new ArrayList<Product>();
    for(Product p : products)
      if(regex.matcher(p.getTitle()).matches())
        productsAfterFiltered.add(p);

     return productsAfterFiltered;
  }
  public List<Product> search( Integer provinceCityId,
                               Long districtId,
                               Long wardId,
                               Long streetId,
                               String priceRange,
                               String searchString){
    List<Address> addresses = null;
    List<Product> products = new ArrayList<Product>();
    if(streetId != null)
      addresses = addressRepository.searchByStreet(streetId);
    else{
      if(wardId !=null)
        addresses = addressRepository.searchByWard(wardId);
      else{
        if(districtId !=null)
          addresses = addressRepository.searchByDistrict(districtId);
        else
          if(provinceCityId !=null )
            addresses = addressRepository.searchByCity(provinceCityId);
      }
    }
    if(addresses != null){
      for(Address a : addresses)
        if(a.getProduct() != null)
          products.add(a.getProduct());

      if(priceRange != null)
        products = filterByPriceRange(products, priceRange);

      if(searchString != null)
        products = filterBySearchSTring(products, searchString);
    }

    return products;
  }
  public List<Product> searchByTitle(String searchString) {return productRepository.searchTitle(searchString);}
  public List<Product> search1 (Integer provinceCityId,
                                Long districtId,
                                Long wardId,
                                Long streetId,
                                String searchString){
    return productRepository.search(provinceCityId, districtId, wardId, streetId, searchString);
  }

}
