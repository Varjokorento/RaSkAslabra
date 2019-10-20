package rsatool;

import utils.OwnBigInteger;
import utils.asciiutil.AsciiUtil;
import decrypter.OwnDecrypter;
import encrypter.OwnEncrypter;
import keys.KeyGenerator;
import keys.JavaLibKeyUtil;
import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;

public class RSATool {
    private KeyGenerator keyGenerator;
    private KeyGenerator libraryKeyGenerator;
    private OwnPublicKey publicKey;
    private OwnPrivateKey privateKey;
    private JavaLibKeyUtil keyUtil;
    private AsciiUtil asciiUtil;
    private OwnEncrypter ownEncrypter;
    private OwnDecrypter decrypter;

    /**
     * Constructor for RSATool.
     * RSATool functions as a sort of facade for the algorithm
     */
    public RSATool() {
        this.keyGenerator = new KeyGenerator();
        this.keyUtil = new JavaLibKeyUtil();
        this.asciiUtil = new AsciiUtil();
        this.decrypter = new OwnDecrypter();
        this.ownEncrypter = new OwnEncrypter();

    }

    private OwnPublicKey getPublicKey() {
        return publicKey;
    }

    private OwnPrivateKey getPrivateKey() {
        return privateKey;
    }

    /**
     * OWN IMPLEMENTATION
     * Generates keys for the tool
     */
    public void generateKeys() {
        keyGenerator.generateKeyPair();
        this.publicKey = keyGenerator.getPublicKey();
        this.privateKey = keyGenerator.getPrivateKey();
    }


    /**
     * OWN IMPLEMENTATION
     * Calls encrypter to encrypt a plaintext String.
     *
     * @return encrypted byteArray of String.
     */
    public OwnBigInteger[] encrypt(String plainText) {
        OwnBigInteger[] cipherAsIntArray = asciiUtil.stringToCipher(plainText);
        return ownEncrypter.encrypt(cipherAsIntArray, this.getPublicKey());
    }
    /**
     * OWN IMPLEMENTATION
     * Calls decrypter to decipher a cryptedByteArray
     *
     * @return decrypted byteArray of String.
     */
    public OwnBigInteger[] decrypt(OwnBigInteger[] encrypted) {
        return decrypter.decrypt(encrypted, this.getPrivateKey(), this.getPublicKey());
    }

    /**
     * OWN IMPLEMENTATION
     * Converts decrypted BigInteger-array to String
     *
     * @return deciphered message
     */
    public String cipherToString(OwnBigInteger[] decrypted) {
        return asciiUtil.cipherToString(decrypted);
    }



}
