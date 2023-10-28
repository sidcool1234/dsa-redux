package org.sid.misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {

    @Test
    void add() {
        var complexNumber = new ComplexNumber(1.0d, 2.0d);
        var addTo = new ComplexNumber(2.0d, 1.0d);
        assertEquals(new ComplexNumber(3.0d, 3.0d), complexNumber.add(addTo));

        // null check
        assertEquals(new ComplexNumber(1.0d, 2.0d), complexNumber.add(null));
    }

    @Test
    void isReal() {
        var complexNumber = new ComplexNumber(1.0d, 2.0d);
        assertFalse(complexNumber.isReal());

        var realNumber = new ComplexNumber(1.0d, 0.0d);
        assertTrue(realNumber.isReal());
    }
}