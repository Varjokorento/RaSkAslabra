package keys;

import keys.keyimpl.OwnKeyPair;
import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;

import java.security.*;

public class KeyGenerator {

    private OwnKeyPairGenerator keyPairGenerator;
    private OwnKeyPair keyPair;

    private KeyPair libraryKeyPair;

    /**LIBRARY IMPLEMENTATION
     * RSA using libraries
     */
    public KeyGenerator(boolean libraryImplementation) throws NoSuchAlgorithmException {
        if (libraryImplementation) {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();
            libraryKeyPair = kp;
        }
    }

    public PublicKey getLibPublicKey() {
        return libraryKeyPair.getPublic();
    }

    public PrivateKey getLibPrivateKey() {
        return libraryKeyPair.getPrivate();
    }


    /**
     * OWN IMPLEMENTATION
     * Constructor for Keygenerator.
     * Gets a keySize as a parameter.
     * Initializes a keyPairGenerator with the keySize
     */
    public KeyGenerator() {
        this.keyPairGenerator = new OwnKeyPairGenerator();
    }


    /**
     * OWN IMPLEMENTATION
     * Generates keyPar with keyPairGenerator.
     *
     */
    public void generateKeyPair(int bitLength) {
        keyPair = keyPairGenerator.generateKeyPair(bitLength);
    }

    /**
     * OWN IMPLEMENTATION
     * Returns generated public key
     * @return PublicKey
     */
    public OwnPublicKey getPublicKey() {
        return keyPair.getPublicKey();
    }
    /**
     * OWN IMPLEMENTATION
     * Returns generated private key
     * @return PrivateKey
     */
    public OwnPrivateKey getPrivateKey() {
        return keyPair.getPrivateKey();
    }





}
