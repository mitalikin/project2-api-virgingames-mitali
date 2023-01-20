package com.virgingames.testsuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AssertionTest2 {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://www.virgingames.com/bingo";
        RestAssured.registerParser("text/plain",Parser.JSON);
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/GetBingoLobbyFeed.do")
                .then().statusCode(200);
    }
    @Test
    public void test001() {
        RestAssured.registerParser("text/plain",Parser.JSON);
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("/GetBingoLobbyFeed.do");
        response.then().statusCode(200);
       response.prettyPrint();
    }
    @Test
    public void test002(){
        response.body("bingoLobbyInfoResource.streams[0]",hasEntry("defaultGameFrequency",300000));
        response.body("bingoLobbyInfoResource.streams[0]",hasEntry("streamName","Adventure"));
    }
}
