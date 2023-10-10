package testing;

import java.util.Iterator;

public class KeyChecker {

    protected KeyStorage validKeys_;
    public KeyChecker(KeyStorage ks) {
        validKeys_ = ks;
    }

    public boolean checkKey(Key user_key) {
    for (Iterator e = validKeys_.iterator(); e.hasNext(); ) {
    if (compare((Key)e.next(), user_key) { return true; }
    }
    return false;
    }

        protected boolean compare(Key key1, Key key2) {
            return false; // originally not there...
        }
    }

