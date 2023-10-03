package pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pojo.registerElements.*;

import java.util.ArrayList;

@Data
public class Claim {

    private String org_name;
    private String edrpou_inn;
    private String email;
    private Address address_legal;
    private Address address_fact;
    private Person representative_person;
    private Person contact_person;
    private BankRef bank_ref;
    private ArrayList<String> cadastrial_numbers;
    private ArrayList<ArrayList<ArrayList<String>>> polygons;
    private Territories territories;
    private ArrayList<Files> files;

    @JsonCreator
    public Claim(@JsonProperty("org_name") String org_name, @JsonProperty("edrpou_inn") String edrpou_inn, @JsonProperty("email") String email,
                 @JsonProperty("address_legal") Address address_legal, @JsonProperty("address_fact") Address address_fact,
                 @JsonProperty("representative_person") Person representative_person, @JsonProperty("contact_person") Person contact_person,
                 @JsonProperty("bank_ref") BankRef bank_ref, @JsonProperty("cadastrial_numbers") ArrayList<String> cadastrial_numbers,
                 @JsonProperty("polygons") ArrayList<ArrayList<ArrayList<String>>> polygons, @JsonProperty("territories") Territories territories,
                 @JsonProperty("files") ArrayList<Files> files) {
        this.org_name = org_name;
        this.edrpou_inn = edrpou_inn;
        this.email = email;
        this.address_legal = address_legal;
        this.address_fact = address_fact;
        this.representative_person = representative_person;
        this.contact_person = contact_person;
        this.bank_ref = bank_ref;
        this.cadastrial_numbers = cadastrial_numbers;
        this.polygons = polygons;
        this.territories = territories;
        this.files = files;
    }
}
