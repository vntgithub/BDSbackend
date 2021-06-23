package vntrieu.train.bdsbackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vntrieu.train.bdsbackend.dto.ContactDTO;
import vntrieu.train.bdsbackend.model.Contact;
import vntrieu.train.bdsbackend.service.ContactService;
@RestController
@RequestMapping("/contact")
@AllArgsConstructor
public class ContactController {
  private final ContactService contactService;

  @PutMapping
  ContactDTO update(@RequestBody Contact c){return new ContactDTO(contactService.update(c));}
  @DeleteMapping("/{id}")
  String delete(@PathVariable Long id){return contactService.delete(id);}
}
