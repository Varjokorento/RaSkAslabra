package keys.keyimpl;

import utils.BigIntegerImpl;

import java.math.BigInteger;

public class OwnPublicKey {
    private BigIntegerImpl e;
    private BigIntegerImpl n;

    public OwnPublicKey(BigIntegerImpl e, BigIntegerImpl n) {
        this.e = e;
        this.n = n;
    }

    public BigIntegerImpl getE() {
        return e;
    }

    public void setE(BigIntegerImpl e) {
        this.e = e;
    }

    public BigIntegerImpl getN() {
        return n;
    }

    public void setN(BigIntegerImpl n) {
        this.n = n;
    }
}
