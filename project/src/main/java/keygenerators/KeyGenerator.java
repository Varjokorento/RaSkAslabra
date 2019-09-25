package keygenerators;

import keyimpl.KeyPairImpl;
import keyimpl.PrivateKeyImpl;
import keyimpl.PublicKeyImpl;

import java.security.*;

public class KeyGenerator {

    private KeyPairGeneratorImpl keyPairGenerator;
    private KeyPairImpl keyPair;

    private KeyPair libraryKeyPair;

    /**
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
     * Constructor for Keygenerator.
     * Gets a keySize as a parameter.
     * Initializes a keyPairGenerator with the keySize
     */
    public KeyGenerator() {
        this.keyPairGenerator = new KeyPairGeneratorImpl();
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
    public PublicKeyImpl getPublicKey() {
        return keyPair.getPublicKey();
    }
    /**
     * Returns generated private key
     * @return PrivateKey
     */
    public PrivateKeyImpl getPrivateKey() {
        return keyPair.getPrivateKey();
    }





}
