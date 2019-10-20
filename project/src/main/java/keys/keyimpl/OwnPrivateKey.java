package keys.keyimpl;

import utils.OwnBigInteger;

public class OwnPrivateKey {
    private OwnBigInteger key;

    public OwnPrivateKey(OwnBigInteger key) {
        this.key = key;
    }

    public OwnBigInteger getPrivateKey() {
        return key;
    }
}
