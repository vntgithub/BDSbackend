package vntrieu.train.bdsbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vntrieu.train.bdsbackend.model.Content;
import vntrieu.train.bdsbackend.model.ContentType;
import vntrieu.train.bdsbackend.model.Filter;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilterDTO {

    private Long id;
    private Object content;

    public FilterDTO (Filter filter) {
        this.id = filter.getId();
        this.content = filter.getContent();
    }
}
