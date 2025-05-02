import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class TestHomework_3 {
    @Test
    public void GetRedirect() {
        String url = "https://playground.learnqa.ru/api/long_redirect";
        boolean flag = true;
        while (flag) {
            Response response = getRequest(url);
            url = response.getHeader("Location");
            if (url == null) {
                System.out.println("редиректа нет " + response.getStatusCode());
                break;
            }
            System.out.println("произошел редирект на адресс " + url);

            if (response.getStatusCode() == 200) {
                flag = false;
            }
        }
    }
    public Response getRequest(String url){
        Response response=RestAssured
                .given()
                .redirects()
                .follow(false)
                .get(url)
                .andReturn();
        return response;
    }

}
