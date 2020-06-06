package org.ebs.utils;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EncryptionManagerTest {

    @Test
    public void TestEncryptShouldReturnBCryptString() {
        char[] pwd = {'H', 'E', 'L', 'L', 'O'};
        String encrypt = EncryptionManager.encrypt(pwd);
        assertTrue(EncryptionManager.validate("HELLO", encrypt));
    }


}
