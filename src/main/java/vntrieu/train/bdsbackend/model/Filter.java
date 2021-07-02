package vntrieu.train.bdsbackend.model;


import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;


import javax.persistence.*;

import java.util.Map;


@Entity
@Table(name = "Filter")
@TypeDef(name = "json", typeClass = JsonFormatTypes.class)
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

    @Convert(converter = HashMapConverter.class, disableConversion = true)
    @Type( type = "json" )
    private Map<String, Object> content;

}
