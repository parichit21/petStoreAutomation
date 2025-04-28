package api.endpoints;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
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
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .pathParams("petId",petid)
                         .when()
                         .get(GET_URL);
                return response;
    }

public static Response updateByPetId(int id,Pet petPayload){
    String updare_URL = getUser().getString("pet_POSTUpdateByID");
        Response response =     given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(petPayload)
                .pathParams("petId",id)
                .when()
                    .post(updare_URL);
            return response;
}

public static Response deletePetRecord(int id ){
        String delete_URL =  getUser().getString("pet_DELETEByPETID");
       Response response =          given()
                        .pathParams("petId",id)
              // .header("api_key","")
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
                .queryParam("status", status)
                .accept(ContentType.JSON)
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

    public  static Response fileUpload(int petId, String metadata, File file){
        String fileuploadUrl = getUser().getString("pet_POSTuploadimage");

                Response response  =        given()
                                .multiPart("additionalMetadata", metadata)
                                .pathParams("petId",petId)
                                .multiPart("file", file)
                        .contentType("multipart/form-data")
                                .when()
                                .post(fileuploadUrl);

                return response;

    }


}
