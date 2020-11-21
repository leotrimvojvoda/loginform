import cdiConfig.DatabaseConfig;
import database.Database;
import entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class DatabaseTests {


    AnnotationConfigApplicationContext path =
            new  AnnotationConfigApplicationContext(DatabaseConfig.class);

    Database database = path.getBean("database",Database.class);


    @Test
    public void addUserTest(){

        User user = new User();
        String languages [] = {"German"};
        user.setFirstName("Lion");
        user.setLastName("Selamni");
        user.setEmail("anik@hotmail.com");
        user.setUserPassword("Deutsch123");
        user.setCountry("Germany");
        user.setAge(3);
        user.setGender('M');
        user.setLanguages(Arrays.toString(languages));

        database.addUser(user);
    }

    @Test
    public void getUserByEmailTest(){

        System.out.println(database.getUserByEmail("tuana@gmail.com").toString());

    }
}
