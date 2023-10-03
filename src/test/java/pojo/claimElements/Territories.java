package pojo.claimElements;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Territories {

    private String first_area;
    private String first_count_area;
    private String area;
    private String count_area;
    private String geo_point_x;
    private String geo_point_y;
    private String region;
    private String district;
    private String city;
    private String street;
    private String house_number;

    @JsonCreator
    public Territories(@JsonProperty("first_area") String first_area, @JsonProperty("first_count_area") String first_count_area,
                        @JsonProperty("area") String area, @JsonProperty("count_area") String count_area,
                        @JsonProperty("geo_point_x") String geo_point_x, @JsonProperty("geo_point_y") String geo_point_y,
                        @JsonProperty("region") String region, @JsonProperty("district") String district,
                        @JsonProperty("city") String city, @JsonProperty("street") String street,
                        @JsonProperty("house_number") String house_number) {
        this.first_area = first_area;
        this.first_count_area = first_count_area;
        this.area = area;
        this.count_area = count_area;
        this.geo_point_x = geo_point_x;
        this.geo_point_y = geo_point_y;
        this.region = region;
        this.district = district;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
    }
}
