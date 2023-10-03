package pojo.registerElements;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BankRef {

    private String mfo;
    private String name;
    private String iban;

    @JsonCreator
    public BankRef(@JsonProperty("mfo") String mfo, @JsonProperty("name") String name,
                  @JsonProperty("iban") String iban) {
        this.mfo = mfo;
        this.name = name;
        this.iban = iban;
    }
}
