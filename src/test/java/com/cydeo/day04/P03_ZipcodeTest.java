package com.cydeo.day04;

import com.utilities.ZipcodeBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P03_ZipcodeTest extends ZipcodeBase {

    /**
     * Create TestBase for zipcode
     * website ----> https://www.zippopotam.us/#
     *
     */

    /**
     Given accept type is json
     and country path param value is "us"
     and postal code path param value is 22102
     When I send get request to http://api.zippopotam.us/{country}/{postal-code}
     Then status code is 200
     Then "post code" is "22102"
     And  "country" is "United States"
     And "place name" is "Mc Lean"
     And  "state" is "Virginia"
     */
    @DisplayName("Create TestBase for zipcode")
    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("country","us")
                .pathParam("post-Code",22102).
                when().get("/{country}/{postal-code}");
       response.prettyPrint();
     assertEquals(200,response.statusCode());

        JsonPath jsonPath = response.jsonPath();

        assertEquals("post code",jsonPath.getString("22102"));
        assertEquals("country",jsonPath.getString("United States"));
        assertEquals("place name",jsonPath.getString("Mc Lean"));
        assertEquals("state",jsonPath.getString("Virginia"));
}}
