package keyGenerators;

import java.security.*;

public class KeyGenerator {

    private KeyPairGenerator keyGenerator;
    private KeyPair keyPair;



    /**
     * Constructor for Keygenerator.
     * Gets a keySize as a parameter.
     * Initializes a keyGenerator with the keySize
     */
    public KeyGenerator(int keySize) throws NoSuchAlgorithmException {
        this.keyGenerator = KeyPairGenerator.getInstance("RSA");
        keyGenerator.initialize(keySize);
    }


    /**
     * Generates keyPar with keyGenerator.
     *
     */
    public void generateKeyPair() {
        keyPair = keyGenerator.generateKeyPair();
    }

    /**
     * Returns generated public key
     * @return PublicKey
     */
    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }
    /**
     * Returns generated private key
     * @return PrivateKey
     */
    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }





}
