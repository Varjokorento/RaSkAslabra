package keys;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class JavaLibKeyUtil {


    /**
     * Reads publicKey from file
     *
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
     *
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
