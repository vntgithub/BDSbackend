package vntrieu.train.bdsbackend.repository;

import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.dto.ContactDTO;
import vntrieu.train.bdsbackend.model.Filter;

import java.util.HashMap;
import java.util.List;

public interface FilterRepository extends JpaRepository<Filter, Long>{

  @Query("SELECT f FROM Filter f WHERE f.user.id=?1")
  public List<Filter> getByUserId(Long id);

  public List<Filter> findAllByContent(HashMap<String, Object> ob);



}
