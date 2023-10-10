package testing.demo_marsicbookcs2401;

import testing.Key;
import testing.Checker;

public class CheckerTest {
    // test case to check that invalid key is rejected
    @Test
    public void checkKey_anyState_invalidKeyRejected() {
        // 1. set up
        Checker checker = new Checker( /* constructor params */ );
        // 2. act
        Key invalidTestKey = new Key( /* setup with invalid code */ );
        boolean result = checker.checkKey(invalidTestKey);
        // 3. verify
        assertEqual(result, false);

    }
}
