package keyimpl;

import java.math.BigInteger;

public class PrivateKeyImpl {
    private BigInteger key;

    public PrivateKeyImpl(BigInteger key) {
        this.key = key;
    }

    public BigInteger getPrivateKey() {
        return key;
    }
}
