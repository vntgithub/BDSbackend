package vntrieu.train.bdsbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id", referencedColumnName = "id")
    private User user;
}
