import cdiConfig.DatabaseConfig;
import database.Database;
import encryption.AES;
import entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DatabaseTests {


    AnnotationConfigApplicationContext path =
            new  AnnotationConfigApplicationContext(DatabaseConfig.class);

    Database database = path.getBean("database",Database.class);


    @Test
    public void addUserTest(){

        User user = new User();
        String languages [] = {"German","Albanian","English"};
        user.setFirstName("Wildfried");
        user.setLastName("Heinrich");
        user.setEmail("email@gmail.com");
        user.setUserPassword("password");
        user.setCountry("Germany");
        user.setAge(100);
        user.setGender('M');
        user.setLanguages(Arrays.toString(languages));

        database.addUser(user);
    }

    @Test
    public void getUserByEmailTest(){

        System.out.println(database.getUserByEmail("tuana@gmail.com").toString());

    }

    @Test
    public void getUserByID() {
        User user = database.getUserByID(49);

        if(user != null){
        String email = AES.decrypt(user.getEmail());

        String password = AES.decrypt(user.getUserPassword());

        System.out.println("Email: "+email+" - Password: "+password);

    }
        else System.out.println("NULL");
    }

    @Test
    public void getAllUsersTest(){
        List<User> user = database.getAllUsers();

        for(User u: user){
            System.out.println(u.getFirstName()+" "+u.getLastName()+" - ");
        }
    }
}
