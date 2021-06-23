package vntrieu.train.bdsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.Contact;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
  private Long id;
  private String email;
  private String phoneNumber;

  public ContactDTO(Contact c) {
    this.id = c.getId();
    this .email = c.getEmail();
    this.phoneNumber = c.getPhoneNumber();
  }
}
