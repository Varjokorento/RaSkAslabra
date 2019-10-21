package decrypter;

import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;
import utils.OwnBigInteger;

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
            decrypted[i] = array[i].modPow(privateKey.getPrivateKey(), publicKey.getN());
        }
        return decrypted;
    }
}
