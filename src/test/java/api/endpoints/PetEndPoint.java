package api.endpoints;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

public class PetEndPoint {

    //    for getting data form propertu fies in resource
    static ResourceBundle getUser(){
        ResourceBundle routes = ResourceBundle.getBundle("petRoutes");
        return routes;
    }

    public static Response findPetByID(int petid){
        String GET_URL = getUser().getString("pet_GET_ByID");
                Response response =  given()
                         .when()
                         .get(GET_URL);
                return response;
    }

public static Response updateByPetId(int id , Pet petPayload){
    String updare_URL = getUser().getString("pet_POSTUpdateByID");
        Response response =     given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParams("petId",id)
                .body(petPayload)
                    .when()
                    .get(updare_URL);
            return response;
}

public static Response deletePetRecord(int id ){
        String delete_URL =  getUser().getString("pet_DELETEByPETID");
       Response response =          given()
                        .pathParams("petId",id)
                .when()
                .delete(delete_URL);
                return response;
}

public static Response updatePetRecord(Pet payload){
    String Put_URL =  getUser().getString("pet_PUT");
         Response response =    given()
                 .contentType(ContentType.JSON)
                 .accept(ContentType.JSON)
                 .body(payload)
                    .when()
                    .put(Put_URL);
    return response;
    }

    public static Response GetByStatus(String status){
        String Get_URL =  getUser().getString("pet_GETByStatus");
        Response response= given()
                .queryParam("status", "available","pending","sold")
                        .when()
                        .get(Get_URL);

        return response;
    }

//    for creating new entry
    public static Response POSTnewEntry(Pet payload){
        String POSTnewUser_URL =  getUser().getString("pet_POST");
             Response response =           given()
                                .contentType(ContentType.JSON)
                                .accept(ContentType.JSON)
                                .body(payload)
                                .when()
                                .post(POSTnewUser_URL);
                        return response;

    }


}
