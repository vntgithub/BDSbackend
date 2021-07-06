package vntrieu.train.bdsbackend.model;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


import javax.persistence.*;



@Entity
@Table(name = "Filter")
@TypeDefs({
        @TypeDef(name = "ContentType", typeClass = ContentType.class)
        ,
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Filter {
    @Id
    @SequenceGenerator(name = "filter_sequence", sequenceName = "filter_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filter_sequence")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;


    @Column(name = "content", columnDefinition = "jsonb")
    @Type(type = "ContentType")
    private Content content;

}
