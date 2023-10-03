package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pojo.claimElements.ValidationError;

import java.util.ArrayList;

@Data
public class ResponseWithErrors {

    private String claim_uuid;
    private String numerator_number;
    private String error_msg;
    private ArrayList<ValidationError> validation_errors;

    public ResponseWithErrors(@JsonProperty("claim_uuid") String claim_uuid, @JsonProperty("numerator_number") String numerator_number,
                              @JsonProperty("error_msg") String error_msg, @JsonProperty("validation_errors") ArrayList<ValidationError> validation_errors) {
        this.claim_uuid = claim_uuid;
        this.numerator_number = numerator_number;
        this.error_msg = error_msg;
        this.validation_errors = validation_errors;
    }
}
