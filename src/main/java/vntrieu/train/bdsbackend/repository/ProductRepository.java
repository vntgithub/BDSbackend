package vntrieu.train.bdsbackend.repository;

import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import vntrieu.train.bdsbackend.Interface.DataNewProductYesterday;
import vntrieu.train.bdsbackend.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

  @Query("SELECT count(id) from Product ")
  Long getNumberOfPage();

  List<Product> findAllBy(Pageable page);

  @Query("SELECT p FROM Product  p WHERE p.user.id=?1")
  public List<Product> getByUserId(Long id, Pageable page);

  public Long countAllByUser_Id(Long id);

  @Query("SELECT p FROM Product p WHERE LOWER(p.title) like %?1% ")
  public List<Product> searchByString(String searchString);

  public List<Product> findAllByAddress_Street_IdOrderByIdAsc(Long id, Pageable p);
  public List<Product> findAllByAddress_Ward_IdOrderByIdAsc(Long id, Pageable p);
  public List<Product> findAllByAddress_District_IdOrderByIdAsc(Long id, Pageable p);
  public List<Product> findAllByAddress_ProvinceCity_IdOrderByIdAsc(Integer id, Pageable p);
  public List<Product> findAllByPriceBetweenOrderByPriceAsc(Long priceStart, Long priceEnd, Pageable page);


}
