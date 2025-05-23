package tests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ex12 {

    @Test
    public void getAndCheckHeaders(){

        Response response= RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        String expectedKeyHeader="X-Secret-Homework-Header";
        String expectedValueHeader="Some secret value";
        Headers headers=response.getHeaders();

        assertAll(
                "Проверка хедера",
                ()->assertTrue(headers.hasHeaderWithName(expectedKeyHeader),
                        "Cookie '" + expectedKeyHeader + "' not found"),
                ()->assertEquals(expectedValueHeader,headers.getValue(expectedKeyHeader),
                        "Header value doesn't match")
        );



    }
}
