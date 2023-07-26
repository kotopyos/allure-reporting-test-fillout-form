package tests;
import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class TestData {
    Faker faker = new Faker();

    public String nameFirst = faker.name().firstName(),
            nameLast = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = randomizeGender(),
            phone = String.valueOf(faker.number().numberBetween(1000000000L, 9999999999L)),
            subject = randomizeSubject(),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            pictureUrl = "123j4.jpg",
            currentAddress = faker.address().fullAddress(),
            birthDateYear = randomNum(1950, 2023).toString(),
            birthDateMonth = faker.options().option("July", "June", "December"),
            birthDateDay = randomNum(1, 18).toString(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana"),
            city = getRandomCity(state);


    public String getRandomCity(String state) {
        if (state.equals("NCR")) return faker.options().option("Delhi", "Gurgaon", "Noida");
        else if (state.equals("Uttar Pradesh")) return faker.options().option("Agra", "Lucknow", "Merrut");
        else if (state.equals("Haryana")) return faker.options().option("Karnal", "Panipat");
        return "";
    }

    private String randomizeGender() {
        switch (randomNum(1, 3)) {
            case 1:
                return "Male";

            case 2:
                return "Female";

            default:
                return "Other";
        }
       }
       private String randomizeSubject(){
           switch (randomNum(1, 7)) {
               case 1:
                   return "English";

               case 2:
                   return "Maths";

               case 3:
                   return "Physics";

               case 4:
                   return "Chemistry";

               case 5:
                   return "Biology";

               case 6:
                   return "Maths";

               default:
                   return "Computer Science";

           }
       }

    private Integer randomNum(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
        }

//        SUBJECTS FULL LIST
//        : "Hindi"
//                : "English"
//                : "Maths"
//                : "Physics"
//                : "Chemistry"
//                : "Biology"
//                : "Computer Science"
//                : "Commerce"
//                : "Economics"
//                : "Arts"
//                : "Social Studies"
//                : "History"
//                : "Civics"

}
