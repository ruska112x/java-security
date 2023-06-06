package com.karabalin.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AffineCipherTest {
    AffineCipher affineCipher;

    @Test
    public void encryptTest0() {
        affineCipher = new AffineCipher(3, 9, 7);
        assertEquals("Ctoox Vxgoq!", affineCipher.encryptWithoutInit("Hello World!"));
    }

    @Test
    public void encryptTest1() {
        affineCipher = new AffineCipher(5, 21, 13);
        assertEquals("Ewh Qhrhac fm Ihqcn", affineCipher.encryptWithoutInit("The Legend of Zelda"));
    }

    @Test
    public void encryptTest2() {
        affineCipher = new AffineCipher(7, 15, 11);
        assertEquals("JPKKPLR HOLKKPYBH 2011", affineCipher.encryptWithoutInit("WILLIAM STALLINGS 2011"));
    }

    @Test
    public void decryptTest0() {
        affineCipher = new AffineCipher(9, 3, 1);
        assertEquals("Java, JUnit, Guava.", affineCipher.decryptWithoutInit("Ebib, EZovq, Dzbib."));
    }

    @Test
    public void decryptTest1() {
        affineCipher = new AffineCipher(11, 19, 27);
        assertEquals("{Zoo, Zoom}", affineCipher.decryptWithoutInit("{Qzz, Qzzd}"));
    }

    @Test
    public void decryptTest2() {
        affineCipher = new AffineCipher(15, 7, 8);
        assertEquals("Limit Theorems for Nonlinear Cointegrating Regression",
                affineCipher.decryptWithoutInit("Rygyh Hjqkdqgs fkd Vkvryvqid Mkyvhqudihyvu Dqudqssykv"));
    }
}