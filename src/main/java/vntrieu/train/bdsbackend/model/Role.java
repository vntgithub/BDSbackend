package vntrieu.train.bdsbackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Role {
    @Id
    @SequenceGenerator(name = "role_sequence", sequenceName = "role_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    @NonNull
    private Short id;

    @NonNull
    private String name;


    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Account> accounts;
}
