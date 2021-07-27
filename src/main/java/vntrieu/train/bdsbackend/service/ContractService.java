package vntrieu.train.bdsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.Interface.CustomerPotential;
import vntrieu.train.bdsbackend.model.Contract;
import vntrieu.train.bdsbackend.repository.ContractRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    public Contract add(Contract c) {
        return contractRepository.save(c);
    }

    public List<Contract> get(){return contractRepository.findAll();}

    public Contract getById(Long id) {
        return contractRepository.findById(id).get();
    }

    public List<Contract> getByUserId(Long id, Pageable p){
        return contractRepository.findAllByUserId(id, p);
    }

    public List<Contract> reportByMonthAndYear(Integer month, Integer year){
        return contractRepository.findAllByDate_Month(year, month);
    }

    public List<CustomerPotential> listCustomerPotential(){
        return contractRepository.listPotentialCustomer();
    }
}
