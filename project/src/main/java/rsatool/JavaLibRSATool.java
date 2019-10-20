package rsatool;

import decrypter.JavaLibDecrypter;
import encrypter.JavaLibEncrypter;
import keys.JavaLibKeyGenerator;
import keys.JavaLibKeyUtil;
import utils.asciiutil.AsciiUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class JavaLibRSATool {

    private JavaLibKeyGenerator keyGenerator;
    private AsciiUtil asciiUtil;
    private JavaLibEncrypter encrypter;
    private JavaLibDecrypter decrypter;
    private JavaLibKeyUtil keyUtil;


    private PublicKey libraryPublicKey;
    private PrivateKey libraryPrivateKey;


    public JavaLibRSATool() throws NoSuchAlgorithmException {
        this.keyGenerator = new JavaLibKeyGenerator();
        this.keyUtil = new JavaLibKeyUtil();
        this.asciiUtil = new AsciiUtil();
        this.decrypter = new JavaLibDecrypter();
        this.encrypter = new JavaLibEncrypter();
    }

    /**
     * Generates privateKeys using libraries
     */

    public void generateKeysWithLibraries() throws NoSuchAlgorithmException {
        libraryPublicKey = keyGenerator.getLibPublicKey();
        libraryPrivateKey = keyGenerator.getLibPrivateKey();
    }

    /**
     * LIBRARY IMPLEMENTATION
     * Library encrypt
     */

    public byte[] encryptWithLibraries(String message) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return encrypter.encrypt(message, libraryPrivateKey);
    }

    /**
     * LIBRARY IMPLEMENTATION
     * Decrypt with libraries
     */

    public String decryptWithLibraries(byte[] encrypted) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        byte[] decrypted = decrypter.decrypt(encrypted, libraryPublicKey);
        return asciiUtil.getStringFromByteArray(decrypted);
    }




}
