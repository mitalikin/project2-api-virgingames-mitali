package com.virgingames.testbase;

import groovy.beans.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;

public class TestBase {


    @BeforeClass
    public static void inIt() {
       // RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured.baseURI = "https://www.virgingames.com";
        RestAssured.basePath = "/bingo";
    }
}
