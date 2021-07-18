package vntrieu.train.bdsbackend.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import vntrieu.train.bdsbackend.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

  @Query("SELECT count(id) from Product ")
  Long getNumberOfPage();

  List<Product> findAllBy(Pageable page);


  @Query("SELECT p FROM Product  p WHERE p.user.id=?1")
  public List<Product> getByUserId(Long id);

  @Query("SELECT p FROM Product p INNER JOIN Address a ON p.address.id = a .id WHERE a.provinceCity.id=?1 ")
  public List<Product> searchByCity(Integer provinceCityId);

  @Query("SELECT p FROM Product p INNER JOIN Address a ON p.address.id = a .id WHERE a.district.id=?1 ")
  public List<Product> searchByDistrict(Long districtId);

  @Query("SELECT p FROM Product p INNER JOIN Address a ON p.address.id = a .id WHERE a.ward.id=?1 ")
  public List<Product> searchByWard(Long wardId);

  @Query("SELECT p FROM Product p INNER JOIN Address a ON p.address.id = a .id WHERE a.street.id=?1 ")
  public List<Product> searchByStreet(Long provinceCityId);


  @Query("SELECT p FROM Product p  WHERE p.price <= 500000000 ")
  public List<Product> searchByPrice500();

  @Query("SELECT p FROM Product p  WHERE p.price > 500000000 and p.price <= 1000000000 ")
  public List<Product> searchByPrice500_1000();

  @Query("SELECT p FROM Product p  WHERE p.price > 1000000000 and p.price <= 1500000000 ")
  public List<Product> searchByPrice1000_1500();

  @Query("SELECT p FROM Product p  WHERE p.price > 1500000000 and p.price <= 2000000000 ")
  public List<Product> searchByPrice1500_2000();

  @Query("SELECT p FROM Product p  WHERE p.price >2000000000 ")
  public List<Product> searchByPrice2000();

  @Query("SELECT p FROM Product p WHERE LOWER(p.title) like %?1% ")
  public List<Product> searchByString(String searchString);


}
