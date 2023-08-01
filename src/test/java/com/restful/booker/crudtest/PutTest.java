package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class PutTest extends TestBase {

    @Test
    public void updateCurrentBooking() {
        BookingPojo.BookingDates date = new BookingPojo.BookingDates();
        date.setCheckIn("2023-01-01");
        date.setCheckout("2023-02-01");
        BookingPojo BookingPojo = new BookingPojo();
        BookingPojo.setFirstName("ABC");
        BookingPojo.setLastName("XYZ");
        BookingPojo.setTotalPrice(100);
        BookingPojo.setDepositPaid(true);
        BookingPojo.setBookingDates(date);
        BookingPojo.setAdditionalNeeds("Breakfast");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .pathParam("id", 111)
                .body(BookingPojo)
                .when().put("{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    }




