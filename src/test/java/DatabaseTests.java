import cdiConfig.DatabaseConfig;
import dao.Database;
import encryption.AES;
import entity.User;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DatabaseTests {


    AnnotationConfigApplicationContext path =
            new  AnnotationConfigApplicationContext(DatabaseConfig.class);

    Database database = path.getBean("database",Database.class);


    @Test
    public void generateUsers(){

        List<User> users = new ArrayList<>();

        Database database = new Database();

        for(int i = 0; i < 25; i++){
            User user = new User();
            user.setFirstName("Wildfried");
            user.setLastName("Heinrich");
            user.setEmail("user"+ ThreadLocalRandom.current().nextInt(100000, 900000 + 1)+"@gmail.com");
            user.setUserPassword("password");
            user.setCountry("Germany");
            user.setAge(99);
            user.setGender('M');
            user.setLanguages("English");
            users.add(user);
            database.addUser(user);
            database.closeStreams();
        }

        System.out.println(users.get(0).getEmail());

    }

    @Test
    public void addUser(){


            User user = new User();
            user.setFirstName("Verified");
            user.setLastName("Heinrich");
            user.setEmail("user"+ ThreadLocalRandom.current().nextInt(100000, 900000 + 1)+"@gmail.com");
            user.setUserPassword("password");
            user.setCountry("Germany");
            user.setAge(99);
            user.setGender('M');
            user.setLanguages("English");
            user.setVerified(true);
            database.addUser(user);
            database.closeStreams();
    }

    @Test
    public void getUserByEmailTest(){

        System.out.println(database.getUserByEmail("leotrim@gmail.com").toString());

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

    @Test
    public void deleteUserByIdTest(){
        database.deleteUserById(39);
    }
}
