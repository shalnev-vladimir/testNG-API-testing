package main.java.files;

public class Payload {

    public static String addPlace() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }

    public static String coursePrice() {
        return "{\"dashboard\": {\n" +
                "\"purchaseAmount\": 1162, \"website\": \"rahulshettyacademy.com\"},\n" +
                "\"courses\": [\n" +
                "{\"title\": \"Selenium Python\", \"price\": 50, \"copies\": 6},\n" +
                "{\"title\": \"Cypress\", \"price\": 40, \"copies\": 4},\n" +
                "{\"title\": \"RPA\", \"price\": 45, \"copies\": 10},\n" +
                "{\"title\": \"Appium\", \"price\": 36, \"copies\": 7}]}";
    }

    public static String addBook(String aisle, String isbn) {
        return "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"" + isbn + "\",\n" +
                "\"aisle\":\"" + aisle + "\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";
    }
}
