import encryption.AES;
import org.junit.jupiter.api.Test;

public class EncryptionTest {

    @Test
    public void getSecurityKeyTest(){

        AES encryption = new AES();

        //System.out.println(encryption.getSecurityKey());

        String email = AES.encrypt("exaple@live.com");
        String password = AES.encrypt("extrasecure");

        System.out.println("Email: "+email+" - Password: "+password);

        System.out.println("SEC KEY: "+AES.getSecurityKey());

        email = AES.decrypt(email);
        password = AES.decrypt(password);
        System.out.println("Email: "+email+" - Password: "+password);


    }

    @Test
    public void testEncryption(){


        String originalString = "howtodoinjava.com";
        String encryptedString = AES.encrypt(originalString) ;
        String decryptedString = AES.decrypt(encryptedString) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);

    }

}
