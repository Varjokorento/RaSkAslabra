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
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class RSATool {
    private KeyGenerator keyGenerator;
    private PublicKeyImpl publicKey;
    private PrivateKeyImpl privateKey;
    private Encrypter encrypter;
    private Decrypter decrypter;
    private KeyUtil keyUtil;
    private BigInteger n;
    private BigInteger phi;

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
        this.n = findN(publicKey.getPublicKey(), privateKey.getPrivateKey());
        this.phi = getPhi(publicKey.getPublicKey(), privateKey.getPrivateKey());
    }

    /**
     * Calls encrypter to encrypt a plaintext String.
     * @return encrypted byteArray of String.
     */
    public byte[] encrypt(String plainText) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        //return encrypter.encrypt(plainText, this.privateKey);
    }

    /**
     * Calls decrypter to decipher a cryptedByteArray
     * @return decrypted byteArray of String.
     */
    public byte[] decrypt(byte[] cryptedByteArray) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        //return decrypter.decrypt(cryptedByteArray, this.publicKey);
    }

    /**
     * Calls keyUtil that writes the generated keys to file
     *
     */
    public void writeKeysToFile() throws IOException {
       // keyUtil.savePublicKeyToFile(this.publicKey);
       // keyUtil.savePrivateKeyToFile(this.privateKey);
    }

    /**
     * Find mod n from keys
     * @param p publicKey
     * @param q privateKey
     * @return mod n
     */

    private BigInteger findN(BigInteger p, BigInteger q) {
        return p.multiply(q);
    }


    /** Compute Phi(n) (Euler's totient function)
     *  Phi(n) = (p-1)(q-1)
     * @return phi
     */
    public BigInteger getPhi(BigInteger p, BigInteger q) {
        return (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
    }

}
