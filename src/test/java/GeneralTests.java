import org.junit.jupiter.api.Test;
import entity.User;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Calendar;

public class GeneralTests {




    @Test
    public void testLombok(){

        String languages [] = {"English", "Albanian", "German"};

        @Valid
        User user = new User();
        user.setId(11);
        user.setFirstName("S");
        user.setLastName("Selmani");
        user.setEmail("fc@w.c");
        user.setUserPassword("123456");
        user.setCountry("XK");
        user.setAge(37);
        user.setGender('M');
        user.setLanguages(Arrays.toString(languages));
        user.setVerified(true);

        System.out.println(user.toString());
    }

    @Test
    public void dateTest(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println(year);
    }


}
