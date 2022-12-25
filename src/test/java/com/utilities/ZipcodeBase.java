package com.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ZipcodeBase {

    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "https://www.zippopotam.us/#";
    }
}