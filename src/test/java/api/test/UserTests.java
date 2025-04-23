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
    @Test(priority = 1)
   public void  TestPostUSer(){
       Response res =  UserEndPoints.createUser(userPayload);
            res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
    }

    @Test(priority = 2)
    public void TestGetUserByName(){
        Response res = UserEndPoints.ReadUser(this.userPayload.getUsername());
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void testUpdateUserByName(){

        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response res = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
        Response responseAfterUpdate = UserEndPoints.ReadUser(this.userPayload.getUsername());
        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testDeleteUserByName(){
       Response res =  UserEndPoints.deleteUser(this.userPayload.getUsername());
       Assert.assertEquals(res.getStatusCode(),200);
    }
}
