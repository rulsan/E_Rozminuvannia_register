package pojo.claimElements;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String first_name;
    private String last_name;
    private String patronymic;
    private String phone;

    @JsonCreator
    public Person(@JsonProperty("first_name") String first_name, @JsonProperty("last_name") String last_name,
                   @JsonProperty("patronymic") String patronymic, @JsonProperty("phone") String phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.phone = phone;
    }
}
