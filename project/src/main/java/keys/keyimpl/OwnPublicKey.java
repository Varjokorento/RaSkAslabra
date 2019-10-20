package keys.keyimpl;

import utils.OwnBigInteger;

public class OwnPublicKey {
    private OwnBigInteger e;
    private OwnBigInteger n;

    public OwnPublicKey(OwnBigInteger e, OwnBigInteger n) {
        this.e = e;
        this.n = n;
    }

    public OwnBigInteger getE() {
        return e;
    }

    public void setE(OwnBigInteger e) {
        this.e = e;
    }

    public OwnBigInteger getN() {
        return n;
    }

    public void setN(OwnBigInteger n) {
        this.n = n;
    }
}
