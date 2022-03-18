package main.java;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import main.java.files.Payload;

import static io.restassured.RestAssured.given;
import static java.lang.System.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class Basic {

    public static void main(String[] args) {
        /*
         TO DO Auto-generated method stub
         validate if Add place API is working as expected

         Add place -> Update place with new address -> Get place to validate if new address is present in response

         given - all input details
         when - submit the API - resource, http method
         then - validate the response
         content of the file to String -> content of the file can convert into Byte -> Byte data to String
        */

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(Payload.addPlace())
                // body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Documents\\name.json")))) - это, чтобы получить данные из файла
                .when().post("/maps/api/place/add/json")
                .then()
                .assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.18 (Ubuntu)")
                .extract().response().asString();

        out.println(response);
        JsonPath js = new JsonPath(response); // for parsing Json
        String placeId = js.getString("place_id");
        out.println(placeId);

        // Update place
        String newAddress = "Summer walk, Africa";

        given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeId + "\",\n" +
                        "\"address\":\"" + newAddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("/maps/api/place/update/json")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        // Get place

        String getPlaceResponse = given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when()
                .get("/maps/api/place/get/json")
                .then()
                .assertThat().log().all()
                .statusCode(200)
                .extract().response().asString();

        JsonPath js1 = ReUsableMethod.rawToJson(getPlaceResponse);
        String actualAddress = js1.getString("address");
        out.println(actualAddress);
        assertEquals(actualAddress, newAddress);
    }

}
