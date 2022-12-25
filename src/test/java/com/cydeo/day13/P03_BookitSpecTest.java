package com.cydeo.day13;

import com.utilities.BookITUtils;
import com.utilities.BookitTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class P03_BookitSpecTest extends BookitTestBase {

    /**
     * Send a request /api/users/me endpoint as teacher
     * verify status code 200
     * content Type will be ContentType.JSON
     */

    @Test
    public void test1() {

        given().log().all()
                .header("Authorization", BookITUtils.getTokenByRole("teacher"))
                .accept(ContentType.JSON).
                when().get("/api/users/me").prettyPeek().
                then().statusCode(200).contentType(ContentType.JSON);
    }

    @Test
    public void test2() {

        given().spec(BookITUtils.getReqSpec("teacher")).
                when().get("/api/users/me").prettyPeek().
                then().spec(BookITUtils.getResSpec(200))
                .body("firstName", is("Barbabas"));
    }


    /***
     *
     *  Create a Parametirized test by using csv file as userInfo.csv
     *
     *   role , firstName
     *   student-member,Raymond
     *   student-leader,Lissie
     *   teacher,Barbabas
     *
     *
     *    Send GET request /api/users/me for each data
     *    Verify status code is 200
     *    content type is JSON
     *    FirstName is firstName from csv File
     *
     */


}

