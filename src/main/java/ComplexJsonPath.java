package main.java;

import io.restassured.path.json.JsonPath;
import main.java.files.Payload;

import static java.lang.System.*;

public class ComplexJsonPath {

    public static void main(String[] args) {
        // to-do Auto-generated method stub
        // we have successfully mocked this response. Because an API is not ready
        JsonPath js = new JsonPath(Payload.coursePrice());

        // print number of courses
        int count = js.getInt("courses.size()");
        out.println(count);

        // print purchase amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        out.println(totalAmount);

        // print title of the first course
        String firstCourseTitle = js.get("courses[0].title"); // or getString()
        out.println(firstCourseTitle);

        // print all course titles and their respective prices
        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            out.print(js.get("courses[" + i + "].price").toString());
            out.println(" " + courseTitles);
        }

        out.println("Print number of copies sold by RPA course");
        for (int i = 0; i < count; i++) {
            String courseTitles = js.getString("courses[" + i + "].title");
            if (courseTitles.equalsIgnoreCase("RPA")) {
                int copies = js.get("courses[" + i + "].copies");
                out.println(copies);
                break;
            }
        }
    }

}
