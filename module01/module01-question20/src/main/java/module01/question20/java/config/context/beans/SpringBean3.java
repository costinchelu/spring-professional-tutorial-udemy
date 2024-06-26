package module01.question20.java.config.context.beans;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class SpringBean3 {

    private final MessageDigest messageDigest;

    public SpringBean3(MessageDigest messageDigest) {
        this.messageDigest = messageDigest;
    }

    public void printHash() {
        byte[] hashBytes = messageDigest.digest("test springBean3".getBytes());
        char[] hashString = Hex.encodeHex(hashBytes);
        System.out.println(hashString);
    }
}
