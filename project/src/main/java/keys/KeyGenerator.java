package keys;

import keys.keyimpl.OwnKeyPair;
import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;


public class KeyGenerator {

    private OwnKeyPairGenerator keyPairGenerator;
    private OwnKeyPair keyPair;

    /**
     * Constructor for Keygenerator.
     * Gets a keySize as a parameter.
     * Initializes a keyPairGenerator with the keySize
     */
    public KeyGenerator() {
        this.keyPairGenerator = new OwnKeyPairGenerator();
    }

    /**
     * Generates keyPar with keyPairGenerator.
     */
    public void generateKeyPair() {
        keyPair = keyPairGenerator.generateKeyPair();
    }

    /**
     * Returns generated public key
     *
     * @return PublicKey
     */
    public OwnPublicKey getPublicKey() {
        return keyPair.getPublicKey();
    }

    /**
     * Returns generated private key
     *
     * @return PrivateKey
     */
    public OwnPrivateKey getPrivateKey() {
        return keyPair.getPrivateKey();
    }


}
