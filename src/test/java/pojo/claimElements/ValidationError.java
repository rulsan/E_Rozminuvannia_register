package pojo.claimElements;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValidationError {

    private String field;
    private String tag;
    private String detailed;

    public ValidationError(@JsonProperty("field") String field, @JsonProperty("tag") String tag,
                              @JsonProperty("detailed") String detailed) {
        this.field = field;
        this.tag = tag;
        this.detailed = detailed;
    }
}
