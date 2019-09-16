package keygenerators;

import java.math.BigInteger;

public class PublicKeyImpl {
    private BigInteger publicKey;

    public PublicKeyImpl(BigInteger publicKey) {
        this.publicKey = publicKey;
    }

    public BigInteger getPublicKey() {
        return publicKey;
    }
}
