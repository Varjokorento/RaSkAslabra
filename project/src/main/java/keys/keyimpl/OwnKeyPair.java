package keys.keyimpl;

public class OwnKeyPair {
    private OwnPublicKey publicKey;
    private OwnPrivateKey privateKey;

    public OwnKeyPair(OwnPublicKey publicKey, OwnPrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public OwnPublicKey getPublicKey() {
        return publicKey;
    }


    public OwnPrivateKey getPrivateKey() {
        return privateKey;
    }

}
