package vntrieu.train.bdsbackend.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Address;
import vntrieu.train.bdsbackend.model.Image;
import vntrieu.train.bdsbackend.model.Product;
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
    //Create address, image
    Address newAddress = addressRepository.save(p.getAddress());
    List<Image> listImage = imageRepository.saveAll(p.getImages());
    //Create new product
    p.setAddress(newAddress);
    p.setImages(listImage);
    Product newProduct =  productRepository.save(p);

    //Add foreign key for image
    newAddress.setProduct(newProduct);
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
}
