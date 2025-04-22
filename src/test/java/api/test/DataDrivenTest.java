package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTest {
    /*
        1. create multiple user
        2. Delete all user */


    @Test(priority = 1, dataProvider = "Data", dataProviderClass = Dataproviders.class)
    public void  TestPostUSer(String userID,String userName, String fname, String lastname, String useremail, String pwd, String ph){
        User userPayload = new User();
        userPayload.setId(Integer.parseInt(userID));
        userPayload.setUsername(userName);
        userPayload.setFirstName(fname);
        userPayload.setLastName(lastname);
        userPayload.setEmail(useremail);
        userPayload.setPassword(pwd);
        userPayload.setPhone(ph);
        Response res =  UserEndPoints.createUser(userPayload);
        Assert.assertEquals(res.getStatusCode(),200);

    }


    @Test(priority = 2, dependsOnMethods = "TestPostUSer", dataProvider = "UserNames", dataProviderClass = Dataproviders.class)
    public void  TestDeleteUSer(String userName){

        Response res =  UserEndPoints.deleteUser(userName);
        Assert.assertEquals(res.getStatusCode(),200);

    }
















}
