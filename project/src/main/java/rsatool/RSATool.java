package rsatool;

import asciiutil.AsciiUtil;
import decrypter.Decrypter;
import encrypter.Encrypter;
import keygenerators.KeyGenerator;
import keygenerators.KeyUtil;
import keyimpl.PrivateKeyImpl;
import keyimpl.PublicKeyImpl;

import java.io.IOException;
import java.math.BigInteger;

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

    private PublicKeyImpl getPublicKey() {
        return publicKey;
    }

    private PrivateKeyImpl getPrivateKey() {
        return privateKey;
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
    public BigInteger[] encrypt(String plainText) {
        BigInteger[] cipherAsIntArray = AsciiUtil.stringToCipher(plainText);
        for (BigInteger i: cipherAsIntArray) {
            System.out.println(i);
        }
        return Encrypter.encrypt(cipherAsIntArray, this.getPublicKey());
    }

    /**
     * Calls decrypter to decipher a cryptedByteArray
     * @return decrypted byteArray of String.
     */
    public BigInteger[] decrypt(BigInteger[] encrypted) {
        return Decrypter.decrypt(encrypted, this.getPrivateKey(), this.getPublicKey());
    }

    /**
     * Converts decrypted BigInteger-array to String
     * @return deciphered message
     */
    public String cipherToString(BigInteger[] decrypted) {
        return AsciiUtil.cipherToString(decrypted);
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
