package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pojo.Claim;
import pojo.Response;

import java.util.List;
import java.util.Map;

import static actions.Action.registerClaim;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.*;
import static utils.PostgreUtil.executeQuery;

public class Test_1 {

    @Test
    @Epic("API interface")
    @Feature("some API feature")
    @Story("Registration story")
    @Description("smoke API test description")
    @Severity(CRITICAL)
    public void checkRegisterClaim() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String listOfJson = "[{" +
                "  \"org_name\": \"АКЦІОНЕРНЕ ТОВАРИСТВО КОМЕРЦІЙНИЙ БАНК «ПРИВАТБАНК»\"," +
                "  \"edrpou_inn\": \"143605117\"," +
                "  \"email\": \"example@mail.ua\"," +
                "  \"address_legal\": {" +
                "    \"post_code\": \"08300\"," +
                "    \"region\": \"Київська\"," +
                "    \"district\": \"Бориспільський\"," +
                "    \"city\": \"Бориспіль\"," +
                "    \"street\": \"Франка\"," +
                "    \"house_number\": \"13\"," +
                "    \"flat\": \"1\"" +
                "  }," +
                "  \"address_fact\": {" +
                "    \"post_code\": \"08300\"," +
                "    \"region\": \"Київська\"," +
                "    \"district\": \"Бориспільський\"," +
                "    \"city\": \"Бориспіль\"," +
                "    \"street\": \"Франка\"," +
                "    \"house_number\": \"14\"," +
                "    \"flat\": \"2\"" +
                "  }," +
                "  \"representative_person\": {" +
                "    \"first_name\": \"Іван\"," +
                "    \"last_name\": \"Мельник\"," +
                "    \"patronymic\": \"Петрович\"," +
                "    \"phone\": \"38(0542)485689\"" +
                "  }," +
                "  \"contact_person\": {" +
                "    \"first_name\": \"Шевченко\"," +
                "    \"last_name\": \"Олександр\"," +
                "    \"patronymic\": \"Олександрович\"," +
                "    \"phone\": \"38(0542)485688\"" +
                "  }," +
                "  \"bank_ref\": {" +
                "    \"mfo\": \"305299\"," +
                "    \"name\": \"ПРИВАТБАНК\"," +
                "    \"iban\": \"UA173000010000032003102901026\"" +
                "  }," +
                "  \"cadastrial_numbers\": [" +
                "    \"8000000000:88:192:0036\"," +
                "    \"0510136600:02:031:0012\"" +
                "  ]," +
                "  \"polygons\": [" +
                "    [" +
                "      [ 30.820321071818178, 49.625253818460365 ]," +
                "      [ 29.677742946517558, 49.05258203497712 ]," +
                "      [ 29.91944216565938, 50.092698416039056 ]," +
                "      [ 30.820321071818178, 49.625253818460365 ]" +
                "    ] ]," +
                "  \"territories\": {" +
                "    \"first_area\": 0.001," +
                "    \"first_count_area\": 5," +
                "    \"area\": 0.001," +
                "    \"count_area\": 5," +
                "    \"geo_point_x\": 30.820321071818178," +
                "    \"geo_point_y\": 49.625253818460365," +
                "    \"region\": \"Київська\"," +
                "    \"district\": \"Бориспільський\"," +
                "    \"city\": \"Бориспіль\"," +
                "    \"street\": \"Франка\"," +
                "    \"house_number\": \"1\"" +
                "  },\n" +
                "  \"files\": [" +
                "    {" +
                "      \"src\": \"http://192.168.189.11:3040/api/v1/claim-register/register/return-file\"," +
                "      \"size\": \"10\"," +
                "      \"name\": \"test.txt\"," +
                "      \"mime_type\": \"text/txt\"" +
                "    }" +
                "  ]" +
                "}]";
        Claim[] claims = objectMapper.readValue(listOfJson, Claim[].class);

        Response response = registerClaim(claims[0]);
        System.out.println(response.toString());
        assertEquals("200", response.getStatus());
        assertFalse(response.getUuid().isEmpty());
        assertTrue(response.getMessage().isEmpty());
    }

    @Test
    @Epic("BD interface")
    @Feature("some DB feature")
    @Story("Getting data from BD")
    @Description("smoke DB test description")
    @Severity(CRITICAL)
    public void checkGettingDataFromDB() {
        List<Map<String, Object>> result = executeQuery("SELECT * FROM public.spatial_ref_sys WHERE srid = 2001;");
        System.out.println(result);
    }
}
