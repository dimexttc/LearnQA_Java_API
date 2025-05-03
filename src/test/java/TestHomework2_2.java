import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestHomework2_2 {
    @Test
    public void taskExecute() throws InterruptedException {
        String url="https://playground.learnqa.ru/ajax/api/longtime_job";
        String token=null;
            JsonPath getTokenAndTime = justUrl(url);
            token = getTokenAndTime.get("token");
            int seconds = getTokenAndTime.get("seconds");
            System.out.println("мы получили токен:+ "+token+" и время равно "+seconds);
            System.out.println("\n------------------------------------------------\n");


            JsonPath requestWithToken=urlAndToken(url,token);
            String status =requestWithToken.get("status");
            System.out.println(status +"\nнужно подождать "+seconds+" секунд");
            System.out.println("\n------------------------------------------------\n");

            Thread.sleep(seconds*1000L);
            JsonPath requestWithTokenAndTime=urlAndToken(url,token);
            status=requestWithTokenAndTime.get("status");
            String result=requestWithTokenAndTime.get("result");
            System.out.println("результат равен "+result+" статус равен "+status );
       }



    public JsonPath justUrl(String url){
        JsonPath response=RestAssured
                .given()
                .get(url)
                .jsonPath();
        return response;
    }

    public JsonPath urlAndToken(String url,String token){
        Map<String,String> query=new HashMap<>();{
            query.put("token",token);
        }
        JsonPath answer=RestAssured
                .given()
                .queryParams(query)
                .get(url)
                .jsonPath();
        return answer;
    }
}