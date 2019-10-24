package decrypter;

import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;
import utils.OwnBigInteger;

public class OwnDecrypter {
    /**
     * Decrypts a given OwnBigInteger-array with a given privateKey and publicKey
     * @param array array to be decrypted
     * @param privateKey privateKey to decrypt with
     * @param publicKey publicKey to decrypt with
     * @return decrypted OwnBigInteger[]
     */
    public OwnBigInteger[] decrypt(OwnBigInteger[] array, OwnPrivateKey privateKey, OwnPublicKey publicKey) {
        OwnBigInteger[] decrypted = new OwnBigInteger[array.length];
        for (int i = 0; i < array.length; i++) {
            decrypted[i] = array[i].modPow(privateKey.getPrivateKey(), publicKey.getN());
        }
        return decrypted;
    }
}
