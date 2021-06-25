package vntrieu.train.bdsbackend.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;;
import vntrieu.train.bdsbackend.model.Product;
import vntrieu.train.bdsbackend.repository.ProductRepository;
@Service
@AllArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public List<Product> getByUserId(Long userId){
    return productRepository.getByUserId(userId);
  }

  public Product add(Product p){
    return productRepository.save(p);
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
