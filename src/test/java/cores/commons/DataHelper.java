package cores.commons;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.Locale;

public class DataHelper {

    private Locale locale = new Locale("en");
    private Faker faker = new Faker(locale);

    public String getEmail(){
        return faker.internet().emailAddress();
    }

    public String getFirstName(){
        return faker.name().firstName();
    }

    public String getLastName(){
        return faker.name().lastName();
    }

    public String getNumber(int length){
        return faker.phoneNumber().subscriberNumber(length);
    }

}
