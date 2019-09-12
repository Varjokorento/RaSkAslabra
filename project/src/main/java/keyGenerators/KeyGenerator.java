package keygenerators;

import java.security.*;

public class KeyGenerator {

    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;



    /**
     * Constructor for Keygenerator.
     * Gets a keySize as a parameter.
     * Initializes a keyPairGenerator with the keySize
     */
    public KeyGenerator(int keySize) throws NoSuchAlgorithmException {
        this.keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);
    }


    /**
     * Generates keyPar with keyPairGenerator.
     *
     */
    public void generateKeyPair() {
        keyPair = keyPairGenerator.generateKeyPair();
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
