package vntrieu.train.bdsbackend.model;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


import javax.persistence.*;
import java.util.HashMap;


@Entity
@Table(name = "Filter")
@TypeDefs({
        @TypeDef(name = "ContentType", typeClass = ContentType.class)
        ,
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Data
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;


    @Column(name = "content", columnDefinition = "jsonb")
    @Type(type = "ContentType")
    private HashMap<String, Object> content;

}
