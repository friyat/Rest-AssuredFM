package com.cydeo.day03;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Homework {
    //TASK 1 :
    //- Given accept type is Json
    //- Path param value- US
    //- When users sends request to /countries
    //- Then status code is 200
    //- And Content - Type is Json
    //- And country_id is US
    //- And Country_name is United States of America
    //- And Region_id is 2

    @DisplayName("GET spartan with Json Path")
    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("value","US").
                when().get("/api/spartans/{id}");

        response.prettyPrint();
        //Then status code is 200
        assertEquals(200,response.statusCode());

        //- And Content - Type is Json
        JsonPath jsonPath = response.jsonPath();
}}
