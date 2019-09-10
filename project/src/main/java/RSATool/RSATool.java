package RSATool;

import decrypter.Decrypter;
import encrypter.Encrypter;
import keyGenerators.KeyGenerator;
import keyGenerators.KeyUtil;

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

    public RSATool() throws NoSuchAlgorithmException {
        this.keyGenerator = new KeyGenerator(2024);
        keyGenerator.generateKeyPair();
        this.publicKey = keyGenerator.getPublicKey();
        this.privateKey = keyGenerator.getPrivateKey();
        this.encrypter = new Encrypter();
        this.decrypter = new Decrypter();
        this.keyUtil = new KeyUtil();
    }

    public byte[] encrypt(String plainText) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return encrypter.encrypt(plainText, this.privateKey);
    }

    public byte[] decrypt(byte[] plainText) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return decrypter.decrypt(plainText, this.publicKey);
    }

    public void writeKeysToFile() throws IOException {
        keyUtil.savePublicKeyToFile(this.publicKey);
        keyUtil.savePrivateKeyToFile(this.privateKey);
    }

}
