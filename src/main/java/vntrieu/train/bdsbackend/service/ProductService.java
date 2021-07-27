package vntrieu.train.bdsbackend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;;
import vntrieu.train.bdsbackend.model.*;
import vntrieu.train.bdsbackend.repository.ContactRepository;
import vntrieu.train.bdsbackend.repository.ImageRepository;
import vntrieu.train.bdsbackend.repository.MessageRepository;
import vntrieu.train.bdsbackend.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private  ProductRepository productRepository;

  @Autowired
  private  ImageRepository imageRepository;

  @Autowired
  private MessageRepository messageRepository;

  @Autowired
  private ContactRepository contactRepository;

  public String getPriceRangeString(Long price) {
    if(price < 500000000)
      return "0";
    if(price >= 500000000 && price < 1000000000)
      return "1";
    if(price >=1000000000 && price < 1500000000)
      return "2";
    if(price >=1500000000 && price <2000000000)
      return "3";
    return "4";
  }

  public static Long roudingPage(Long numberOfProduct){
    Long n =  numberOfProduct/10;
    Short m = (short) (numberOfProduct%10);
    if(m != 0)
      return n + 1;
    return n;
  }
  public Long getNumberOfPage(){
    return roudingPage(productRepository.getNumberOfPage());
  }

  public List<Product> getProduct(Pageable page){
    return productRepository.findAllBy(page);
  }

  public Long countPageByUserId(Long id){
    return roudingPage(productRepository.countAllByUser_Id(id));

  }

  public List<Product> getByUserId(Long userId, Pageable page){
    return productRepository.getByUserId(userId, page);
  }

  public Product add(Product p){

    //Add product
    Product newProduct =  productRepository.save(p);
    Collection<Image> listImage =  newProduct.getImages();
    for(Image i : listImage){
      i.setProduct(newProduct);
      imageRepository.save(i);
    }
    List<Contact> listContact = contactRepository.searchContact(
            p.getAddress().getStreet().getId().toString(),
            p.getAddress().getWard().getId().toString(),
            getPriceRangeString(p.getPrice())
    );
    for(Contact c : listContact){
      if(messageRepository.existsById(c.getId())){
        MessageModel updateData = messageRepository.getOne(c.getId());
        Set<Long> newListIdProduct = updateData.getListProductId();
        newListIdProduct.add(newProduct.getId());
        messageRepository.save(updateData);
      }else {
        Set<Long> list = new HashSet<Long>();
        list.add(newProduct.getId());
        MessageModel newMess = new MessageModel( c, list);
        messageRepository.save(newMess);
      }
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

  public List<Product> filterByPriceRange(List<Product> products, Long priceStart, Long priceEnd){
    //List<Product> productsAfterFiltered = new ArrayList<Product>();
    return  products
            .stream()
            .filter(item -> item.getPrice() > priceStart && item.getPrice() <= priceEnd)
            .collect(Collectors.toList());
  }
  public List<Product> filterBySearchSTring(List<Product> products, String searchString){

    List<Product> productsAfterFiltered = new ArrayList<Product>();
    for(Product p : products)
      if(p.getTitle().toLowerCase(Locale.ROOT).contains(searchString.toLowerCase(Locale.ROOT)))
        productsAfterFiltered.add(p);

     return productsAfterFiltered;
  }
  public List<Product> search(Integer provinceCityId,
                              Long districtId,
                              Long wardId,
                              Long streetId,
                              Long priceStart,
                              Long priceEnd,
                              String searchString,
                              Pageable page
  ){

    List<Product> products = null;

    if(streetId != null)
      products = productRepository.findAllByAddress_Street_IdOrderByIdAsc(streetId, page);
    if(wardId != null && products == null)
      products = productRepository.findAllByAddress_Ward_IdOrderByIdAsc(wardId, page);
    if(districtId != null && products == null)
      products = productRepository.findAllByAddress_District_IdOrderByIdAsc(districtId, page);
    if(provinceCityId != null && products == null)
      products = productRepository.findAllByAddress_ProvinceCity_IdOrderByIdAsc(provinceCityId, page);

    if(priceStart != null && priceEnd != null){
      if(products == null){
        products = productRepository.findAllByPriceBetweenOrderByPriceAsc(priceStart, priceEnd, page);
      }else{
        products = filterByPriceRange(products, priceStart, priceEnd);
      }
    }

    if(searchString != null){
      if(products == null)
        products = productRepository.searchByString(searchString);
      else{
        products = filterBySearchSTring(products, searchString);
      }
    }

    return products;
  }

  public Product getProductById (Long id){
    return productRepository.findById(id).get();
  }

}
