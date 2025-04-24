package api.endpoints;

import api.payload.Order;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class OrderEndPoints {

//    for getting data form propertu fies in resource
    static ResourceBundle getUser(){
        ResourceBundle routes = ResourceBundle.getBundle("storeRoutes");
        return routes;
    }


    public static Response GetInventory(Order orderPayload){
        String GetURL = getUser().getString("Get_URL");
       Response response =  given()
                .when()
                .get(GetURL);
return response;
    }

    public static Response Postorder(Order OrderPayload){
        String post_URL = getUser().getString("post_URL");
      Response response =   given()
              .contentType(ContentType.JSON)
              .accept(ContentType.JSON)
              .body(OrderPayload)
              .when()
              .post(post_URL);
      return response;
    }

    public static Response GetOrgerId(int petid){
        String GETOrderId_URL = getUser().getString("Get_UserByID");

       Response response =  given()
                      .pathParams("petid",petid)
                        .when()
                        .get(GETOrderId_URL);
       return response;

    }

    public static Response deleteByID(int id ){
        String DeleteOrder_URL = getUser().getString("Delete_URL");

        Response response =  given()
                .pathParams("id", id)
                        .when()
                       .delete(DeleteOrder_URL);
       return response;
    }



}
