package api.endpoints;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class OrderEndPoints {

//    for getting data form propertu fies in resource
    static ResourceBundle getUser(){
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;
    }


    public static Response GetInventory(){
        String GetURL = getUser().getString("Get_URL");
       Response response =  given()
                .when()
                .get(GetURL);
return response;
    }

//    public static Response Postorder(int id,int petId,int quantity,String shipDate, String[] status,boolean complete){
//
//      Response response =   given().
//                          when().post("post_URL");
//
//      return response;
//    }




}
