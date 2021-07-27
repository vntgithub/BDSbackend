package vntrieu.train.bdsbackend.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "message")
@TypeDefs({
        @TypeDef(name = "SetProductIdType", typeClass = SetProductIdType.class)
        ,
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@NoArgsConstructor
@Data
public class MessageModel {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "contact_id")
    private Contact contact;


    @Column(name = "list_product_id", columnDefinition = "jsonb")
    @Type(type = "SetProductIdType")
    private Set<Long> listProductId;

    public MessageModel(Contact contact, Set<Long> listProductId) {
        this.contact = contact;
        this.listProductId = listProductId;
    }
}
