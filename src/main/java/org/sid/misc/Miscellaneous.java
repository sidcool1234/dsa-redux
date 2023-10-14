package org.sid.misc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Miscellaneous {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(Base64.getEncoder().encodeToString(sha256("a")));
    }

    static byte[] sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes());
    }
}

record ComplexNumber(Double real, Double imaginary) {
    ComplexNumber add(ComplexNumber complexNumber) {
        if (complexNumber == null) return this;

        return new ComplexNumber(this.real + complexNumber.real, this.imaginary + complexNumber.imaginary);
    }

    boolean isReal() {
        return this.imaginary == 0.0;
    }
}