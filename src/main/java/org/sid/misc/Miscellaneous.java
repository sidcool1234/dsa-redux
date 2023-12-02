package org.sid.misc;

import org.jetbrains.annotations.NotNull;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Miscellaneous {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        CollectionsMisc.collections();
    }

    static byte[] sha256(@NotNull String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes());
    }
}

record ComplexNumber(Double real, Double imaginary) implements Comparable<ComplexNumber> {
    ComplexNumber add(ComplexNumber complexNumber) {
        if (complexNumber == null) return this;

        return new ComplexNumber(this.real + complexNumber.real, this.imaginary + complexNumber.imaginary);
    }

    boolean isReal() {
        return this.imaginary == 0.0;
    }


    @Override
    public int compareTo(@NotNull ComplexNumber other) {
        double thisMagnitude = Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
        double otherMagnitude = Math.sqrt(other.real * other.real + other.imaginary * other.imaginary);

        return Double.compare(thisMagnitude, otherMagnitude);
    }
}

class CollectionsMisc {

    public static void collections() {
        PriorityQueue<ComplexNumber> pq = new PriorityQueue<>();
        pq.add(new ComplexNumber(1.0d, 2.0d));
        pq.add(new ComplexNumber(0.0d, 0.0d));
        pq.add(new ComplexNumber(-1.0d, 9.0d));

        System.out.println(pq.poll());
    }

}