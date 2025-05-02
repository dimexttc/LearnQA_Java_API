import  io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

public class TestHomework2_1 {

    @Test
    public void TestRedirect(){
        Response responseFirst=RestAssured
                .given()
                .redirects()
                .follow(true)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        String theRedirectLocation=responseFirst.getHeader("x-host");
        System.out.println(theRedirectLocation);

    }
}
