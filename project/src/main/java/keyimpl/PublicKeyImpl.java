package keyimpl;

import java.math.BigInteger;

public class PublicKeyImpl {
    private BigInteger e;
    private BigInteger n;

    public PublicKeyImpl(BigInteger e, BigInteger n) {
        this.e = e;
        this.n = n;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }
}
