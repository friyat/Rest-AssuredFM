package com.cydeo.day13;

import com.utilities.SpartanNewTestBase;
import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.utilities.SpartanNewTestBase.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class P02_SpartanSpecTest extends SpartanNewTestBase {

    @Test
    public void getAllSpartans() {

        given().log().all().accept(ContentType.JSON)
                .auth().basic("admin","admin").
                when().get("/spartans").//prettyPeek().
                then().
                statusCode(200)
                .contentType(ContentType.JSON);

    }

    @Test
    public void getAllSpartansWithReqResSpec() {

        given().spec(reqSpec).
                when().get("/spartans").prettyPeek().
                then().spec(resSpec);

    }


    @Test
    public void getSingleSpartansWithReqResSpec() {


        given().spec(reqSpec).
                pathParam("id",7).
                when().get("/spartans/{id}").prettyPeek().
                then().spec(resSpec)
                .body("id",is(7));

    }

    @Test
    public void getSingleSpartanAsUser(){

        given().spec(dynamicReqSpec("user","user"))
                .pathParam("id",9).
                when().get("/spartans/{id}").prettyPeek().
                then().spec(dynamicResSpec(200));

    }





    /**
     *  Create GET_RBAC.csv
     *   username,password,id,statuscode
     *    admin,admin,3,200
     *    editor,editor,3,200
     *    user,user,3,200
     *
     *  Create a parameterized test to check RBAC for GET method
     *
     *
     */

    @ParameterizedTest
    @CsvFileSource(resources = "/GET_RBAC.csv",numLinesToSkip = 1)
    public void getSingleSpartan_GETRBACS(String user,String pass,int id,int statusCode){

        given().spec(dynamicReqSpec(user,pass))
                .pathParam("id",id).
                when().get("/spartans/{id}").prettyPeek().
                then().spec(dynamicResSpec(statusCode));

    }




    /**
     *  Create DELETE_RBAC.csv
     *   username,password,id,statuscode
     *
     *    editor,editor,3,403
     *    user,user,3,403
     *    admin,admin,3,204
     *
     *  Create a parameterized test to check RBAC for GET method
     *
     *
     */

    @ParameterizedTest
    @CsvFileSource(resources = "/DELETE_RBAC.csv",numLinesToSkip = 1)
    public void deleteSingleSpartan_DELETERBACS(String user,String pass,int id,int statusCode){

        given().spec(dynamicReqSpec(user,pass))
                .pathParam("id",id).
                when().delete("/spartans/{id}").
                then().spec(dynamicResSpec(statusCode));

    }


}
