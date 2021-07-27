package vntrieu.train.bdsbackend.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "seen")
    private Boolean isSeen;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product ;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
}
