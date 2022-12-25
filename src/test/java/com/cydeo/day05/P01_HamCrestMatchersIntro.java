package com.cydeo.day05;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
        import static org.hamcrest.MatcherAssert.*;
        import static org.hamcrest.Matchers.*;



public class P01_HamCrestMatchersIntro {

    @Test
    public void numbers(){
        //it comes from Junit5 to make assertions
        assertEquals(9,3+6);

        // Hamcrest Matchers comes from RestAssured dependency
        // import static org.hamcrest.MatcherAssert.*;
        // import static org.hamcrest.Matchers.*;
        // Adding following static import we are not gonna us classnames
        // while we are calling method from related classes

        assertThat(9,is(6+3));

        assertThat(9,is(equalTo(6+3)));

        assertThat(9,equalTo(6+3));

        /**
         * is(someValue)
         * is(equalTo(someValue))
         * equalTo(someValue)
         */
        assertThat(5+5,not(9));
    }
    @Test
    public void testStrings(){

        String msg="API is fun!";

        assertThat(msg,is("API is fun!"));
        assertThat(msg,equalTo("API is fun!"));
        assertThat(msg,equalToIgnoringCase("api is fun!"));

        assertThat(msg,startsWith("API"));
        assertThat(msg,startsWithIgnoringCase("api"));

        assertThat(msg,endsWith("fun!"));
        assertThat(msg,endsWithIgnoringCase("FUN!"));

        assertThat(msg,containsString("is"));
        assertThat(msg,containsStringIgnoringCase("IS"));

        assertThat(msg,not("Fun!"));
        assertThat(msg,is(not("Fun!")));


    }
    @Test
    public void testCollections(){
        List<Integer> numberLst = Arrays.asList( 3, 5, 1, 77, 44, 76 ) ; // 6 elements here

        //how to check size of elements
        assertThat(numberLst,hasSize(6));

        // how to check 44 is into collection
        assertThat(numberLst,hasItem(44));
        // assertThat(numberLst,hasItem(2));  to make it fail

        // how to check 44 and 76 is into collection
        assertThat(numberLst,hasItems(44,76));
        assertThat(numberLst,hasItems(44,76,1));
        // assertThat(numberLst,hasItems(44,76,1,2)); to make it fail

        assertThat(numberLst,hasItems(greaterThan(70)));

        //everyItem --> check each element into array about realted condition
        assertThat(numberLst,everyItem(greaterThanOrEqualTo(1)));

        assertThat(numberLst,containsInRelativeOrder(3, 5, 1, 77, 44, 76));



    }
}
