package keys.keyimpl;

import utils.BigIntegerImpl;

import java.math.BigInteger;

public class OwnPrivateKey {
    private BigIntegerImpl key;

    public OwnPrivateKey(BigIntegerImpl key) {
        this.key = key;
    }

    public BigIntegerImpl getPrivateKey() {
        return key;
    }
}
