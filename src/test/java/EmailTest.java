import org.junit.jupiter.api.Test;
import verification.EmailUtil;
import verification.EmailUtilMulti;


import java.util.concurrent.ThreadLocalRandom;

public class EmailTest {

    @Test
    public void sendTestEmail(){
        int code = ThreadLocalRandom.current().nextInt(100000, 900000 + 1);

        System.out.println("CODE: "+code);

        EmailUtil.sendEmail("leotrima19@gmail.com","Your confirmation code is: "+String.valueOf(code));
    }

    @Test
    public void emailThreadTest(){
        EmailUtilMulti multi = new EmailUtilMulti("leotrima19@gmail.com","321234");
        multi.run();
    }
}
