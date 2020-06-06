package org.ebs.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public final class EncryptionManager {

    public static String encrypt(char[] array) {
        byte[] bytesArray = Conversion.CharArrayToByteArray(array);
        return BCrypt.hashpw(bytesArray, getSalt());
    }

    private static String getSalt() {
        return BCrypt.gensalt();
    }

    public static boolean validate(String pwd, String token) {
        return BCrypt.checkpw(pwd, token);
    }
}