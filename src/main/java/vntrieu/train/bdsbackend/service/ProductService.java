package vntrieu.train.bdsbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Product;
import vntrieu.train.bdsbackend.repository.ProductRepository;
@Service
@AllArgsConstructor
public class ProductService {
  private final ProductRepository repository;

  public Product add(Product p){
    return repository.save(p);
  }
}
