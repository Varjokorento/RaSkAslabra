package keyimpl;

import keyimpl.PrivateKeyImpl;
import keyimpl.PublicKeyImpl;

public class KeyPairImpl {
    private PublicKeyImpl publicKey;
    private PrivateKeyImpl privateKey;

    public KeyPairImpl(PublicKeyImpl publicKey, PrivateKeyImpl privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public PublicKeyImpl getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKeyImpl publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKeyImpl getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKeyImpl privateKey) {
        this.privateKey = privateKey;
    }
}
