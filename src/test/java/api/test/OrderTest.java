package api.test;

import api.RetryLogic.RetryAnalyzer;
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

        orderPayload.setId(faker.number().numberBetween(0,9));
        orderPayload.setPetid(faker.number().numberBetween(0,9));
        orderPayload.setQuantity(faker.number().randomDigitNotZero());
        orderPayload.setShipDatee(faker.date().toString());
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void TestGetorder(){
        Response res = OrderEndPoints.GetInventory(this.orderPayload);
                res
                        .then()
                        .log().all();
        Assert.assertEquals(res.getStatusCode(),200);
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
public void TestPostOrder(){
        Response res = OrderEndPoints.Postorder(this.orderPayload);
        res.then()
                .log().all();
        Assert.assertEquals(res.getStatusCode(),200);
    }
        @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void TestGetUserByID(){
        Response res = OrderEndPoints.GetOrderId(this.orderPayload.getPetid());
        res.then()
                .log().all();
        Assert.assertEquals(res.getStatusCode(),200);
        }

        @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
        public void DeleteUserID(){
Response res = OrderEndPoints.deleteByID(this.orderPayload.getPetid());
            res.then()
                    .log().all();
            Assert.assertEquals(res.getStatusCode(),200,"deleted");

        }

}
