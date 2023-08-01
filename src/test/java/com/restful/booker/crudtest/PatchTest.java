package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchTest extends TestBase {

    @Test
    public void updateARecordPartially() {
        BookingPojo patchBookingPojo = new BookingPojo();
        patchBookingPojo.setAdditionalNeeds("Dinner");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .pathParam("id", 111)
                .body(patchBookingPojo)
                .when().patch("{id}");
        response.then().statusCode(403);
        response.prettyPrint();
    }
}
