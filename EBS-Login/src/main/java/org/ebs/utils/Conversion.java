package org.ebs.utils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Conversion {

    public static byte[] CharArrayToByteArray(char[] src) {
        CharBuffer charBuffer = CharBuffer.wrap(src);
        ByteBuffer byteBuffer = Charset.forName(StandardCharsets.UTF_8.name()).encode(charBuffer);
        byte[] copy = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        Arrays.fill(byteBuffer.array(), (byte) 0);
        return copy;
    }


}
