package com.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class NewsAPITestBase {

    @BeforeAll
    public static void init(){

        RestAssured.baseURI="https://newsapi.org/v2";

    }


}
