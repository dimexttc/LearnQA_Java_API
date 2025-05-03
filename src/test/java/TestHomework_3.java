import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class TestHomework_3 {
    @Test
    public void getRedirect(){
       String url="https://playground.learnqa.ru/api/long_redirect";
       boolean flag=true;

       while (flag){
           Response response=getAnswer(url);
           String url1=response.getHeader("Location");
           if (url1==null){
               System.out.println("редиректа нет "+" мы на сайте "+url);
                break;
           }
           System.out.println("редирект произошел с сайта "+url +" на сайт "+url1);
           url=url1;
           if (response.getStatusCode()==200){
               flag=false;
           }

       }
    }

    public Response getAnswer(String url){
        Response response=RestAssured
                .given()
                .redirects()
                .follow(false)
                .get(url)
                .andReturn();
        return response;
    }
}
