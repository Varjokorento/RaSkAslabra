package rsatool;

import decrypter.Decrypter;
import encrypter.Encrypter;
import keygenerators.KeyGenerator;
import keygenerators.KeyUtil;
import keygenerators.PrivateKeyImpl;
import keygenerators.PublicKeyImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class RSATool {
    private KeyGenerator keyGenerator;
    private PublicKeyImpl publicKey;
    private PrivateKeyImpl privateKey;
    private Encrypter encrypter;
    private Decrypter decrypter;
    private KeyUtil keyUtil;

    /**
     * Constructor for RSATool.
     * RSATool functions as a sort of facade for the algorithm
     */
    public RSATool() {
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
    public byte[] encrypt(String plainText) {
        byte[] encrypted = encrypter.encrypt(plainText, this.privateKey);
        return encrypted;
    }

    /**
     * Calls decrypter to decipher a cryptedByteArray
     * @return decrypted byteArray of String.
     */
    public byte[] decrypt(byte[] cryptedByteArray) {
        byte[] decrypted = decrypter.decrypt(cryptedByteArray, this.publicKey);
        return decrypted;
    }

    /**
     * Calls keyUtil that writes the generated keys to file
     *
     */
    public void writeKeysToFile() throws IOException {
       // keyUtil.savePublicKeyToFile(this.publicKey);
       // keyUtil.savePrivateKeyToFile(this.privateKey);
    }


}
