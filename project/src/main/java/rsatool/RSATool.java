package rsatool;

import utils.asciiutil.AsciiUtil;
import decrypter.Decrypter;
import encrypter.Encrypter;
import keygenerators.KeyGenerator;
import keygenerators.KeyUtil;
import keyimpl.PrivateKeyImpl;
import keyimpl.PublicKeyImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSATool {
    private KeyGenerator keyGenerator;
    private KeyGenerator libraryKeyGenerator;
    private PublicKeyImpl publicKey;
    private PrivateKeyImpl privateKey;
    private KeyUtil keyUtil;
    private AsciiUtil asciiUtil;
    private Encrypter encrypter;
    private Decrypter decrypter;
    private PublicKey libraryPublicKey;
    private PrivateKey libraryPrivateKey;

    /**
     * Constructor for RSATool.
     * RSATool functions as a sort of facade for the algorithm
     */
    public RSATool() {
        this.keyGenerator = new KeyGenerator();
        this.keyUtil = new KeyUtil();
        this.asciiUtil = new AsciiUtil();
        this.decrypter = new Decrypter();
        this.encrypter = new Encrypter();

    }

    private PublicKeyImpl getPublicKey() {
        return publicKey;
    }

    private PrivateKeyImpl getPrivateKey() {
        return privateKey;
    }

    /** OWN IMPLEMENTATION
     * Generates keys for the tool
     *
     */
    public void generateKeys(int bitLength) {
        keyGenerator.generateKeyPair(bitLength);
        this.publicKey = keyGenerator.getPublicKey();
        this.privateKey = keyGenerator.getPrivateKey();
    }

    /**
     * LIBRARY IMPLEMENTATION
     * Generates privateKeys using libraries
     */

    public void generateKeysWithLibraries() throws NoSuchAlgorithmException {
        libraryKeyGenerator = new KeyGenerator(true);
        libraryPublicKey = libraryKeyGenerator.getLibPublicKey();
        libraryPrivateKey = libraryKeyGenerator.getLibPrivateKey();

    }

    /**
     * OWN IMPLEMENTATION
     * Calls encrypter to encrypt a plaintext String.
     * @return encrypted byteArray of String.
     */
    public BigInteger[] encrypt(String plainText) {
        BigInteger[] cipherAsIntArray = asciiUtil.stringToCipher(plainText);
        return encrypter.encrypt(cipherAsIntArray, this.getPublicKey());
    }

    /**
     * LIBRARY IMPLEMENTATION
     * Library encrypt
     */

    public byte[] encryptWithLibraries(String message) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return encrypter.encrypt(message, libraryPrivateKey);
    }

    /**
     * OWN IMPLEMENTATION
     * Calls decrypter to decipher a cryptedByteArray
     * @return decrypted byteArray of String.
     */
    public BigInteger[] decrypt(BigInteger[] encrypted) {
        return decrypter.decrypt(encrypted, this.getPrivateKey(), this.getPublicKey());
    }
    /**
     * LIBRARY IMPLEMENTATION
     * Decrypt with libraries
     */

    public String decryptWithLibraries(byte[] encrypted) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        byte[] decrypted = decrypter.decrypt(encrypted, libraryPublicKey);
        return asciiUtil.getStringFromByteArray(decrypted);
    }
    /**
     * OWN IMPLEMENTATION
     * Converts decrypted BigInteger-array to String
     * @return deciphered message
     */
    public String cipherToString(BigInteger[] decrypted) {
        return asciiUtil.cipherToString(decrypted);
    }

    /**LIBRARY IMPLEMENTATION
     * Calls keyUtil that writes the generated keys to file
     *
     */
    public void writeKeysToFile() throws IOException {
        keyUtil.savePublicKeyToFile(this.publicKey);
        keyUtil.savePrivateKeyToFile(this.privateKey);
    }


}
