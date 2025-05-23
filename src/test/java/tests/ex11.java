package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.*;

public class ex11 {

@Test
    public void getAndCheckCookie(){
        Response response= RestAssured
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();
        String expectedCookieKey="HomeW1ork";
        String expectedCookieValue="hw_value";
        Map<String,String> cookies=response.getCookies();

    assertAll("Cookie checks",
            () -> assertTrue(cookies.containsKey(expectedCookieKey),
                    "Cookie '" + expectedCookieKey + "' not found"),
            () -> assertEquals(expectedCookieValue, cookies.get(expectedCookieKey),
                    "Cookie value doesn't match"));

}
}
