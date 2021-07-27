package vntrieu.train.bdsbackend.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.Interface.CustomerPotential;
import vntrieu.train.bdsbackend.model.Contract;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    public List<Contract> findAllByUserId(Long id, Pageable p);

    @Query(value = "SELECT * FROM contract c WHERE extract(year from c.date) = ?1 AND  extract(month from c.date) = ?2", nativeQuery = true)
    public List<Contract> findAllByDate_Month(Integer year, Integer month);

    @Query(value = "select p.id, p.name as name_user, ct.email as email, ct.phone_number as phone_number, count(c.id) as count_contract " +
            "from contract c inner join person p on c.u_id = p.id inner join contact ct on ct.id= p.contact_id " +
            "group by p.id, name_user, email, phone_number " +
            "order by count(c.id) desc", nativeQuery = true)
    public List<CustomerPotential> listPotentialCustomer();

//    public List<Contract> findAllByDate_(Integer month);
}
