package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {

    private String uuid;
    private String status;
    private String message;

    public Response(@JsonProperty("uuid") String uuid, @JsonProperty("status") String status,
                 @JsonProperty("message") String message) {
        this.uuid = uuid;
        this.status = status;
        this.message = message;
    }
}
