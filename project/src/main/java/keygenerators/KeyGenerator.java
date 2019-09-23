package keygenerators;

import keyimpl.KeyPairImpl;
import keyimpl.PrivateKeyImpl;
import keyimpl.PublicKeyImpl;

public class KeyGenerator {

    private KeyPairGeneratorImpl keyPairGenerator;
    private KeyPairImpl keyPair;



    /**
     * Constructor for Keygenerator.
     * Gets a keySize as a parameter.
     * Initializes a keyPairGenerator with the keySize
     */
    public KeyGenerator(int keySize) {
        this.keyPairGenerator = new KeyPairGeneratorImpl();
    }


    /**
     * Generates keyPar with keyPairGenerator.
     *
     */
    public void generateKeyPair() {
        keyPair = keyPairGenerator.generateKeyPair(2);
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
