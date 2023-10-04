package tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Claim;
import pojo.Response;
import pojo.ResponseWithErrors;
import pojo.claimElements.Person;

import java.util.List;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static steps.Steps.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;
import static utils.Utils.*;

@Epic("API interface")
@Feature("some API feature")
public class TestRegistration {

    private final static Logger logger = LogManager.getLogger();

    @Test
    @DisplayName("check ability to apply claim")
    @Story("Registration story")
    @Description("smoke API test description")
    @Severity(CRITICAL)
    public void checkRegisterClaim() {
        Claim[] claims = getClaimsFromFile();
        logger.info(claims[0].getContact_person());
        claims[0].setEdrpou_inn("777777777");
        Person person = Person.builder().first_name("Петро").last_name("Петров").patronymic("Петрович").phone("38(099)12345678").build();
        claims[0].setRepresentative_person(person);
        Response response = registerClaim(claims[0]);
        step("Check the fields: status - 200, uuid is not empty, message is empty");
        assertEquals("200", response.getStatus());
        assertFalse(response.getUuid().isEmpty());
        assertTrue(response.getMessage().isEmpty());
    }

    @Test
    @DisplayName("check validation if cadastrian numbers")
    @Story("Validation field")
    @Description("check validation if cadastrian numbers more that 24 symbols")
    @Severity(CRITICAL)
    public void checkValidationOfCadastrianNumbers() {
        Claim[] claims = getClaimsFromFile();
        claims[0].setCadastrial_numbers(of("1234567890123456789012345","0510136600:02:031:0012"));
        ResponseWithErrors response = registerClaimWithValidationErrors(claims[0]);
        step("Check that error message is 'Максимальна кількість символів має бути 24'");
        assertEquals("Максимальна кількість символів має бути 24",
                response.getValidation_errors().get(0).getDetailed());
    }

    @Test()
    @DisplayName("check connection to DB")
    @Story("Getting data from BD")
    @Description("smoke DB test description")
    @Severity(CRITICAL)
    public void checkGettingDataFromDB() {
        List<Map<String,Object>> result = getDataFromDB("SELECT * FROM public.spatial_ref_sys WHERE srid = 2001;");
        step(result.toString());
    }
}
