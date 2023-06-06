package com.karabalin.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherTest {

    private CaesarCipher caesarCipher;

    @BeforeEach
    void setUp() {
        caesarCipher = new CaesarCipher();
    }

    @Test
    public void encryptTest0() {
        assertEquals("Olssv Dvysk!", caesarCipher.encrypt("Hello World!", 7));
    }

    @Test
    public void encryptTest1() {
        assertEquals("Gur Yrtraq bs Mryqn", caesarCipher.encrypt("The Legend of Zelda", 13));
    }

    @Test
    public void encryptTest2() {
        assertEquals("VHKKHZL RSZKKHMFR 2011", caesarCipher.encrypt("WILLIAM STALLINGS 2011", 25));
    }

    @Test
    public void decryptTest0() {
        assertEquals("Java, JUnit, Guava.", caesarCipher.decrypt("Izuz, ITmhs, Ftzuz.", 25));
    }

    @Test
    public void decryptTest1() {
        assertEquals("{Zoo, Zoom}", caesarCipher.decrypt("{Qff, Qffd}", 17));
    }

    @Test
    public void decryptTest2() {
        assertEquals("Limit Theorems for Nonlinear Cointegrating Regression",
                caesarCipher.decrypt("Qnrny Ymjtwjrx ktw Stsqnsjfw Htnsyjlwfynsl Wjlwjxxnts", 5));
    }
}