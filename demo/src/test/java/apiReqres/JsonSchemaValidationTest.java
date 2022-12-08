package apiReqres;

import helpers.specApiRequestResponse.Specification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidationTest {

    private final static String URL = "https://reqres.in/";

    @Test
    public void schemaValidateTest() {
        Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpecUnique(200));

        given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
    }
}
