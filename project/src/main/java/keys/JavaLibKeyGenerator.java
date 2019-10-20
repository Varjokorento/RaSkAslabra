package keys;

import java.security.*;

public class JavaLibKeyGenerator {

    private KeyPair libraryKeyPair;

    /**
     * LIBRARY IMPLEMENTATION
     * RSA using libraries
     */
    public JavaLibKeyGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        libraryKeyPair = kp;
    }


    public PublicKey getLibPublicKey() {
        return libraryKeyPair.getPublic();
    }

    public PrivateKey getLibPrivateKey() {
        return libraryKeyPair.getPrivate();
    }

}
