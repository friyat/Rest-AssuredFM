package com.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class HrTestBase {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI="http://3.85.201.5/1000/ords/hr/";

        //
    }
}
