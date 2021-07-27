package vntrieu.train.bdsbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.Contract;


@Data
@NoArgsConstructor
public class ContractDTO {
    private Long id;
    private ProductDTO productDTO;
    private UserDTO userDTO;

    public ContractDTO(Contract contract) {
        this.id = contract.getId();
        this.productDTO = new ProductDTO(contract.getProduct());
        this.userDTO = new UserDTO(contract.getUser());
    }
}
