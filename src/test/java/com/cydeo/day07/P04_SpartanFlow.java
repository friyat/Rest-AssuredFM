package com.cydeo.day07;

import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P04_SpartanFlow extends SpartanTestBase {
    /*
    Create a Spartan Flow to run below testCases dynamicly
   - POST     /api/spartans
            Create a spartan Map
                name = "API Flow POST"
                gender="Male"
                phone=1231231231l
            - verify status code 201
            - message is "A Spartan is Born!"
            - take spartanID from response and save as a global variable
    - GET  Spartan with spartanID     /api/spartans/{id}
             - verify status code 200
             - verfiy name is API Flow POST*/
    @DisplayName("POST spartan with String body")
    @Test
    public void test1() {

        String requestBody = "{\n" +
                "     \"gender\":\"Male\",\n" +
                "     \"name\":\"API Flow POST\",\n" +
                "     \"phone\":1234567893\n" +
                "     }";
        String expectedMessage = "A Spartan is Born!";

        int id = 203;
            JsonPath jsonPath = given().accept(ContentType.JSON).log().body()
                    .contentType(ContentType.JSON)
                    .body(requestBody).
                    when().post("/api/spartans").prettyPeek().
                    then().statusCode(201)
                    .contentType("application/json").extract().jsonPath();

            assertEquals(expectedMessage,jsonPath.getString("success"));
            assertEquals("API Flow POST",jsonPath.getString("data.name"));
            assertEquals("Male",jsonPath.getString("data.gender"));
           // assertEquals("1234567893L",jsonPath.getLong("data.phone"));
        //int id1 = jsonPath.getInt("data.id");
        //System.out.println("id = " + id);

    }
    /*

    - PUT  Spartan with spartanID    /api/spartans/{id}
             Create a spartan Map
                name = "API PUT Flow"
                gender="Female"
                phone=3213213213l
             - verify status code 204
    - GET  Spartan with spartanID     /api/spartans/{id}
             - verify status code 200
             - verify name is API PUT Flow
    - DELETE  Spartan with spartanID   /api/spartans/{id}
             - verify status code 204
     - GET  Spartan with spartanID   /api/spartans/{id}
             - verify status code 404
    Challenges
       Create @Test annotated method for each Request
       Put them in order to execute as expected
                    - Use your googling skills
                    - How to run Junit5 Tests in order  ?
     */

}
