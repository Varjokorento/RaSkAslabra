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

    public void setPublicKey(OwnPublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public OwnPrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(OwnPrivateKey privateKey) {
        this.privateKey = privateKey;
    }
}
