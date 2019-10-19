package keys;

import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyUtil {
    private static final String PUBLIC_KEY = "publicKey";
    private static final String PRIVATE_KEY = "privateKey";


    /**
     * Saves public Key to .pub file
     */
    public void savePublicKeyToFile(OwnPublicKey pubKey) throws IOException {
        /*try (FileOutputStream out = new FileOutputStream(PUBLIC_KEY + ".pub")) {
            out.write(pubKey.getN().toByteArray());
            out.write(pubKey.getE().toByteArray());
        }*/
    }
    /**
     * Saves private Key to .key file
     */
    public void savePrivateKeyToFile(OwnPrivateKey privateKey) throws IOException {
       /* try (FileOutputStream out = new FileOutputStream(PRIVATE_KEY + ".key")) {
            out.write(privateKey.getPrivateKey().toByteArray());
        }*/
    }
    /**
     * Reads publicKey from file
     * @return PublicKey
     */
    public static PublicKey readPublicKeyFile(String path) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        X509EncodedKeySpec ks = new X509EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey pub = kf.generatePublic(ks);
        return pub;
    }

    /**
     * Reads privateKey from file
     * @return privateKey
     */
    public static PrivateKey readPrivateKeyFile(String path) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey pvt = kf.generatePrivate(ks);
        return pvt;
    }

}
