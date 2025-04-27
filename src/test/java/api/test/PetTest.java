package api.test;

import api.endpoints.PetEndPoint;
import api.payload.Pet;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;


public class PetTest {
    Faker faker;
    Pet petpayload;

    @BeforeClass
    public void setUpDate(){
        faker = new Faker();
        petpayload = new Pet();

        /*
              int id;
             Category category;
             String name;
             List<String> photoUrls;
             List<Tag> tags;
             String status; // available, pending, sold

        */
        petpayload.setId(faker.idNumber().hashCode());

//        for Category under PET
        Pet.Category category = new Pet.Category();
        category.setId(faker.number().numberBetween(1,10));
        category.setName(faker.name().name());

        petpayload.setCategory(category);
//        For Tag class under Pet
        Pet.Tag pettag = new Pet.Tag();
        pettag.setId(faker.number().numberBetween(1,10));
        pettag.setName(faker.name().name());

        petpayload.setTags(Collections.singletonList(pettag));

//        petpayload.setTags((List<Pet.Tag>) pettag);

        petpayload.setStatus(faker.options().option("available","pending","sold"));
    }

    @Test(priority = 1)
public void POSTnewEntryTest(){
       Response response =  PetEndPoint .POSTnewEntry(this.petpayload);
        response.prettyPrint();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200,"Succesfull new creating");
        // Optional: Verify if name or id matches
        Assert.assertEquals(response.jsonPath().getInt("id"), petpayload.getId(), "Pet ID should match");
        Assert.assertEquals(response.jsonPath().getString("name"), petpayload.getName(), "Pet name should match");

    }
    @Test(priority = 2)
    public void updatePetRecordTest(){
        // Change only the name
        String newName = faker.name().firstName();
        petpayload.setName(newName);

           Response response =  PetEndPoint.updatePetRecord(this.petpayload);
                response.prettyPrint();
                response.then().log().all();
                Assert.assertEquals(response.getStatusCode(),200,"Succesful updated");
        Assert.assertEquals(response.jsonPath().getString("name"), newName, "Name should be updated");
    }
        @Test(priority = 3)
    public void GetByStatusTest(){

            String statusToSearch = "pending";
            Response response = PetEndPoint.GetByStatus(statusToSearch);

            response.then().log().all();
            Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 OK");

            List<String> allStatuses = response.jsonPath().getList("status");
            for (String status : allStatuses) {
                Assert.assertEquals(status, statusToSearch, "All pets should have status = " + statusToSearch);
            }
    }
        @Test(priority = 4)
    public void findPetByIDTest(){

        Response response =   PetEndPoint.findPetByID(2);
                response.then().log().all();
                Assert.assertEquals(response.getStatusCode(),200);
        }

        @Test(priority = 5)
public void updateByPetIdTest(){
       // Pet.Tag pettag =   new Pet.Tag();
   //     pettag.setName("ozzy");

            Pet.Category category = new Pet.Category();
     category.setName("ozzy");
     category.setId(2);
            petpayload.setCategory(category);
            petpayload.setStatus("sold");

            int id =2;

            Response response = PetEndPoint.updateByPetId(id,petpayload);
            response.then().log().all();
            Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 OK");

        }






}
