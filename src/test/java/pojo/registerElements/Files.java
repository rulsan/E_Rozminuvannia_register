package pojo.registerElements;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Files {
    private String src;
    private String size;
    private String name;
    private String mime_type;

    @JsonCreator
    public Files(@JsonProperty("src") String src, @JsonProperty("size") String size,
                 @JsonProperty("name") String name, @JsonProperty("mime_type") String mime_type) {
        this.src = src;
        this.size = size;
        this.name = name;
        this.mime_type = mime_type;
    }
}
