package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private Integer numberOfContract;
}
