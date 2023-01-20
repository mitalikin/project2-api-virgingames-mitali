package com.virgingames.testsuite;

import com.virgingames.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;


public class GetBingoRecord extends TestBase {
    static ValidatableResponse response;
    @Test
    public void test001() {
        //getting record details
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
        //Assert element from record
    RestAssured.registerParser("text/plain",Parser.JSON);
    response =  given().log().all()
            .contentType(ContentType.JSON)
            .when()
            .get("/GetBingoLobbyFeed.do")
            .then().statusCode(200);

    response.body("bingoLobbyInfoResource.streams[0].streamName",equalTo("Adventure"));
    response.body("bingoLobbyInfoResource.streams[0]",hasEntry("defaultGameFrequency",300000));
}


}
