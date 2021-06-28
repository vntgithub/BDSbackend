package vntrieu.train.bdsbackend.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
  private Long id;
  private String name, avt;
  private Boolean gender;
  private LocalDate dateOfBirth;
  private AddressDTO address;
  private ContactDTO contact;

  public UserDTO(User u){
    this.id = u.getId();
    this.name = u.getName();
    this.gender = u.getGender();
    this.avt = u.getAvt();
    this.dateOfBirth = u.getDateOfBirth();
    this.address = new AddressDTO(u.getAddress());
    this.contact = new ContactDTO(u.getContact());
  }
}
