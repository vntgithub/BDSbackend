package vntrieu.train.bdsbackend.service;

import java.util.Collection;
import java.util.List;
import javax.imageio.ImageReader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;;
import vntrieu.train.bdsbackend.model.Image;
import vntrieu.train.bdsbackend.model.Product;
import vntrieu.train.bdsbackend.repository.ImageRepository;
import vntrieu.train.bdsbackend.repository.ProductRepository;
@Service
@AllArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final ImageRepository imageRepository;

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
}
