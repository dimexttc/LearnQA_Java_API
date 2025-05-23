package tests;

import  io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;


public class TestHomeork2 {
    @Test
    public void Homework_get() {
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        response.prettyPrint();


        List<Map<String,String>> uniqAnswer= response.get("messages");
        String check=uniqAnswer.get(1).get("message");
        String finalResult=check.substring(2,check.length()-3);
        if (finalResult.equals("d this is a second mess")){
            System.out.println("The test is passed");
        }
        else {
            System.out.println("The test is failed");
        }



    }
}

