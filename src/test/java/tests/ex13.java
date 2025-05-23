package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ex13 {

    @ParameterizedTest
    @CsvFileSource(resources = "/userAgentInfo.txt",delimiter = '|')
    public void checkUserAgent(
            String userAgent,
            String expectedPlatform,
            String expectedBrowser,
            String expectedDevice){



    JsonPath response=RestAssured
            .given()
            .headers("User-Agent",userAgent)
            .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
            .jsonPath();



        assertAll(

                ()->assertEquals(expectedDevice,response.getString("device"),"неверное устройство"),
                ()->assertEquals(expectedBrowser,response.getString("browser"),"неверный браузер"),
                ()->assertEquals(expectedPlatform,response.getString("platform"),"это неверная платформа")
    );
    }

}
