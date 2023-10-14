package org.sid.misc;

public class Miscellaneous {
    public static void main(String[] args) {

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

