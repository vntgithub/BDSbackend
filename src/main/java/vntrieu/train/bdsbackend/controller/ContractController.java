package vntrieu.train.bdsbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.ExcelExport.CustomerExcelExporter;
import vntrieu.train.bdsbackend.Interface.CustomerPotential;
import vntrieu.train.bdsbackend.dto.ContractDTO;
import vntrieu.train.bdsbackend.dto.CustomerDTO;
import vntrieu.train.bdsbackend.model.Contract;
import vntrieu.train.bdsbackend.service.ContractService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contract")
@CrossOrigin(origins = "http://localhost:3000/")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @PostMapping()
    public String ContractDTO(@RequestBody Contract contract){
        contractService.add(contract);
       return "Done";
    }

    @GetMapping
    public List<ContractDTO> getList(){
        List<Contract> list = contractService.get();
        List<ContractDTO> listDTO = new ArrayList<ContractDTO>();
        for(Contract c : list)
            listDTO.add(new ContractDTO(c));
        return listDTO;
    }
    @GetMapping("/{month}/{year}")
    public List<ContractDTO> reportByMonthAndYear(@PathVariable Integer month, @PathVariable Integer year){
        List<Contract> list = contractService.reportByMonthAndYear(month, year);
        List<ContractDTO> listDTO = new ArrayList<ContractDTO>();
        for(Contract c : list)
            listDTO.add(new ContractDTO(c));
        return listDTO;
    }

    @GetMapping("/listcustomer")
    public ResponseEntity<InputStreamResource> listCustomer() throws IOException {
        List<CustomerPotential> list = contractService.listCustomerPotential();
        List<CustomerDTO> listCustomer = new ArrayList<CustomerDTO>();
        for(CustomerPotential c : list){
            listCustomer.add(new CustomerDTO(c.getId(), c.getName_User(), c.getPhone_number(), c.getEmail(), c.getCount_Contract()));
        }

        CustomerExcelExporter customerExcelExporter = new CustomerExcelExporter(listCustomer);

        ByteArrayInputStream in = customerExcelExporter.export();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=listcustomer.xlsx");

        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));


    }
}
