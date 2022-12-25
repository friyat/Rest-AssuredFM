package com.cydeo.day03;

import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P03_SpartanWithResponsePath extends SpartanTestBase {

    /*
     Given accept type is json
     And path param id is 10
     When user sends a get request to "api/spartans/{id}"
     Then status code is 200
     And content-type is "application/json"
     And response payload values match the following:
          id is 10,
          name is "Lorenza",
          gender is "Female",
          phone is 3312820936
   */
    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .queryParam("q", "{\"region_id\":2}").
                when().get("/countries");

        //Then status code is 200
        assertEquals(200,response.statusCode());

        //And content-type is "application/json"
        assertEquals("application/json",response.contentType());
       // And response payload values match the following:
       // id is 10,
        //        name is "Lorenza",
         //       gender is "Female",
        //        phone is 3312820936

        int id = response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");

        System.out.println("id = " + id);

        //if the path is incorrect it will return NULL
        String address = response.path("address");
        System.out.println("address = " + address);

        //Assertions
        assertEquals(10,id);
        assertEquals("Lorenza",name);
        assertEquals("Female",gender);
        assertEquals(3312820936l,phone);
    }


    }
