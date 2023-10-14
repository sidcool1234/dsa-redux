package org.sid.misc;

import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Miscellaneous {
    public static void main(String[] args) throws NoSuchAlgorithmException {

    }

    static byte[] sha256(@NotNull String input) throws NoSuchAlgorithmException {
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