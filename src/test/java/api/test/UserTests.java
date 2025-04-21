package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {
    Faker faker;
    User userPayload;
    @BeforeClass
    public void setUpdata(){
            faker = new Faker();
            userPayload = new User();
 /*
     int  id;
     String   username;
    String firstName;
    String  lastName;
    String   email;
    String   password;
    String   phone;
    int   userStatus;
 */
           userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

    }
    @Test
   public void  TestPostUSer(){
       Response res =  UserEndPoints.createUser(userPayload);
            res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
    }




}
