package vntrieu.train.bdsbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vntrieu.train.bdsbackend.dto.ContactDTO;
import vntrieu.train.bdsbackend.model.Contact;
import vntrieu.train.bdsbackend.service.ContactService;
@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:3000/")
public class ContactController {
  @Autowired
  private  ContactService contactService;

  @PutMapping
  ContactDTO update(@RequestBody Contact c){return new ContactDTO(contactService.update(c));}
  @DeleteMapping("/{id}")
  String delete(@PathVariable Long id){return contactService.delete(id);}
}
