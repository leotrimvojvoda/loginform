import encryption.AES;
import org.junit.jupiter.api.Test;

public class EncryptionTest {

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
