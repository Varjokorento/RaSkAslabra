package decrypter;

import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;
import utils.OwnBigInteger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class OwnDecrypter {
    /**
     * @param array
     * @param privateKey
     * @param publicKey
     * @return
     */
    public OwnBigInteger[] decrypt(OwnBigInteger[] array, OwnPrivateKey privateKey, OwnPublicKey publicKey) {
        OwnBigInteger[] decrypted = new OwnBigInteger[array.length];
        for (int i = 0; i < array.length; i++) {
            decrypted[i] = array[i].modPow(publicKey.getN(), privateKey.getPrivateKey());
        }
        return decrypted;
    }
}
