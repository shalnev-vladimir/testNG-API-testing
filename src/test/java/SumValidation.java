package test.java;

import io.restassured.path.json.JsonPath;
import main.java.files.Payload;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static java.lang.System.*;
import static org.testng.Assert.assertEquals;

public class SumValidation {

    @Test
    public void sumOfCourses() {
        int sum = 0;
        JsonPath js = new JsonPath(Payload.coursePrice());
        int count = js.getInt("courses.size()");
        for (int i = 0; i < count; i++) {
            int price = js.getInt("courses[" + i + "].price");
            int copies = js.getInt("courses[" + i + "].copies");
            int amount = price * copies;
            out.println(amount);
            sum += amount;
        }
        out.println(sum);
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");

        assertEquals(purchaseAmount, sum,
                "Expected purchase amount is " + purchaseAmount + ". But actual is " + sum);
    }

}
