package main.java.files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import main.java.ReUsableMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.lang.System.*;

public class DynamicJson {

    @Test(dataProvider = "Books Data")
    public void addBook(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given()
                .header("Content-Type", "application/json")
                .body(Payload.addBook(aisle, isbn))
                .when()
                .post("/Library/Addbook.php")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        JsonPath js = ReUsableMethod.rawToJson(response);
        String id = js.get("ID");
        out.println(id);

        // delete book
    }

    @DataProvider(name = "Books Data")
    public Object[][] getData() {
        return new Object[][] {
                {"gfjs", "562"},
                {"jdsk67d", "gsy"},
                {"426", "nsh"}
        };
    }
}
