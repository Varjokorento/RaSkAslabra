package rsatool;

import decrypter.Decrypter;
import encrypter.Encrypter;
import keygenerators.KeyGenerator;
import keygenerators.KeyUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSATool {
    private KeyGenerator keyGenerator;
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private Encrypter encrypter;
    private Decrypter decrypter;
    private KeyUtil keyUtil;

    /**
     * Constructor for RSATool.
     * RSATool functions as a sort of facade for the algorithm
     */
    public RSATool() throws NoSuchAlgorithmException {
        this.keyGenerator = new KeyGenerator(2024);
        this.encrypter = new Encrypter();
        this.decrypter = new Decrypter();
        this.keyUtil = new KeyUtil();
    }
    /**
     * Generates keys for the tool
     *
     */
    public void generateKeys() {
        keyGenerator.generateKeyPair();
        this.publicKey = keyGenerator.getPublicKey();
        this.privateKey = keyGenerator.getPrivateKey();
    }

    /**
     * Calls encrypter to encrypt a plaintext String.
     * @return encrypted byteArray of String.
     */
    public byte[] encrypt(String plainText) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return encrypter.encrypt(plainText, this.privateKey);
    }

    /**
     * Calls decrypter to decipher a cryptedByteArray
     * @return decrypted byteArray of String.
     */
    public byte[] decrypt(byte[] cryptedByteArray) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return decrypter.decrypt(cryptedByteArray, this.publicKey);
    }

    /**
     * Calls keyUtil that writes the generated keys to file
     *
     */
    public void writeKeysToFile() throws IOException {
        keyUtil.savePublicKeyToFile(this.publicKey);
        keyUtil.savePrivateKeyToFile(this.privateKey);
    }

}
