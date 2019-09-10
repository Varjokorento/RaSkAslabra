package keyGenerators;

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


    public void savePublicKeyToFile(KeyPair keyPair) throws IOException {
        try (FileOutputStream out = new FileOutputStream(PUBLIC_KEY + ".pub")) {
            out.write(keyPair.getPublic().getEncoded());
        }
    }

    public void savePrivateKeToFile(KeyPair keyPair) throws IOException {
        try (FileOutputStream out = new FileOutputStream(PRIVATE_KEY + ".pub")) {
            out.write(keyPair.getPrivate().getEncoded());
        }
    }
    //TODO
    public PublicKey readPublicKeyFile() throws NoSuchAlgorithmException, InvalidKeySpecException {
    /*    byte[] bytes = Files.readAllBytes(Paths.get(pubKeyFile));
        X509EncodedKeySpec ks = new X509EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey pub = kf.generatePublic(ks);
        return pub;*/
        return null;
    }
    //TODO
    public PrivateKey readPrivateKeyFile() throws NoSuchAlgorithmException, InvalidKeySpecException {
        /*
        byte[] bytes = Files.readAllBytes(Paths.get(pvtKeyFile));
        PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey pvt = kf.generatePrivate(ks);*/
        return null;
    }

}
