import  io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;


public class TestHomeork2 {
    @Test
    public void homework_get(){
        JsonPath answerFull=RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        answerFull.prettyPrint();
        List<Map<String,String>> whatWeNeed=answerFull.get("messages");
        System.out.println(whatWeNeed.get(1));

    }

    }

