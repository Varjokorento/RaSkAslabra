package keys.keyimpl;

import java.math.BigInteger;

public class OwnPrivateKey {
    private BigInteger key;

    public OwnPrivateKey(BigInteger key) {
        this.key = key;
    }

    public BigInteger getPrivateKey() {
        return key;
    }
}
