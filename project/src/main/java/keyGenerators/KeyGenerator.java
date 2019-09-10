package keyGenerators;

import java.security.*;

public class KeyGenerator {

    private KeyPairGenerator keyGenerator;
    private KeyPair keyPair;


    public KeyGenerator(int keySize) throws NoSuchAlgorithmException {
        this.keyGenerator = KeyPairGenerator.getInstance("RSA");
        keyGenerator.initialize(keySize);
    }

    public void generateKeyPair() {
        keyPair = keyGenerator.generateKeyPair();
    }

    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }





}
