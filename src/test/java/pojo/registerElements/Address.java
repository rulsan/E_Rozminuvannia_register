package pojo.registerElements;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {

    private String post_code;
    private String region;
    private String district;
    private String city;
    private String street;
    private String house_number;
    private String flat;

    @JsonCreator
    public Address(@JsonProperty("post_code") String post_code, @JsonProperty("region") String region,
                   @JsonProperty("district") String district, @JsonProperty("city") String city,
                   @JsonProperty("street") String street, @JsonProperty("house_number") String house_number,
                   @JsonProperty("flat") String flat) {
        this.post_code = post_code;
        this.region = region;
        this.district = district;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.flat = flat;
    }
}
