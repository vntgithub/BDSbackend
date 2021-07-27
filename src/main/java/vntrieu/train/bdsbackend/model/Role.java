package vntrieu.train.bdsbackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String name;

}
