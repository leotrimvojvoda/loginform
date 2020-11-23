import org.junit.jupiter.api.Test;
import verification.EmailUtil;


import java.util.concurrent.ThreadLocalRandom;

public class EmailTest {

    @Test
    public void sendTestEmail(){
        EmailUtil emailUtil = new EmailUtil();

        int code = ThreadLocalRandom.current().nextInt(100000, 900000 + 1);

        emailUtil.sendForReal("leotrima19@gmail.com",String.valueOf(code));

    }
}
