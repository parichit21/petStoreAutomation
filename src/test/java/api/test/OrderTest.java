package api.test;

import api.endpoints.OrderEndPoints;
import api.payload.Order;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrderTest {
    Faker faker;
    Order orderPayload;
    /*
       int id ;
       int petid;
       int quantity;
       String shipDatee;
       String []  status;
       boolean complete;
    */
    @BeforeTest
    public void fakeData(){
        faker = new Faker();
        orderPayload = new Order();

        orderPayload.setId(faker.idNumber().hashCode());
        orderPayload.setPetid(faker.idNumber().hashCode());
        orderPayload.setQuantity(faker.number().randomDigitNotZero());
        orderPayload.setShipDatee(faker.date().toString());
    }

    @Test(priority = 1)
    public void TestGetorder(){
        Response res = OrderEndPoints.GetInventory(this.orderPayload);
                res
                        .then()
                        .log().all();
        Assert.assertEquals(res.getStatusCode(),200);
    }




}
