package com.karabalin.problems;

import com.google.common.collect.HashBiMap;

import java.util.Scanner;

class Matrix2D {
    // looks like this:
    // a b
    // c d
    int a, b, c, d;

    public Matrix2D() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
    }

    public Matrix2D(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getDeterminant() {
        return a * d - b * c;
    }

    @Override
    public String toString() {
        return String.format("%d %d\n%d %d", a, b, c, d);
    }
}


public class HillCipher {
    int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    Matrix2D matrix;
    Matrix2D inverseMatrix;

    HashBiMap<Integer, Character> alphabetLowerCase;

    HashBiMap<Integer, Integer> inverseElement;
    int alphabetLength = 0;

    void init() {
        matrix = new Matrix2D();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Matrix looks like:");
        System.out.println("a b\nc d");
        System.out.println("Enter the matrix elements: ");
        System.out.print("a = ");
        matrix.a = scanner.nextInt();
        System.out.print("b = ");
        matrix.b = scanner.nextInt();
        System.out.print("c = ");
        matrix.c = scanner.nextInt();
        System.out.print("d = ");
        matrix.d = scanner.nextInt();
    }

    public HillCipher() {
        alphabetLength = 27;
        alphabetLowerCase = HashBiMap.create();
        inverseElement = HashBiMap.create();
        int i = 0, j = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetLowerCase.put(i, c);
            i++;
        }
        alphabetLowerCase.put(27, '_');
        for (i = 0; i < alphabetLength; i++) {
            for (j = 0; j < alphabetLength; j++) {
                if ((i * j) % alphabetLength == 1) {
                    inverseElement.put(i, j);
                }
            }
        }
        do {
            init();
        } while (matrix.getDeterminant() == 0 || gcd(matrix.getDeterminant(), alphabetLength) != 1);
        int at = inverseElement.get((matrix.getDeterminant() + alphabetLength) % alphabetLength);
        inverseMatrix = new Matrix2D();
        inverseMatrix.a = (at * matrix.d) % alphabetLength;
        inverseMatrix.b = (at * -matrix.b + alphabetLength) % alphabetLength;
        inverseMatrix.c = (at * -matrix.c + alphabetLength) % alphabetLength;
        inverseMatrix.d = (at * matrix.a) % alphabetLength;
        System.out.println("Encryption matrix:\n" + matrix);
        System.out.println("Decryption matrix:\n" + inverseMatrix);
    }

    public String encrypt(String text) {
        if (text.length() % 2 != 0) {
            text += "_";
        }
        text = text.replaceAll("\\s+", "_").toLowerCase();
        StringBuilder stringBuilder = new StringBuilder(text.length());
        for (int i = 0; i < text.length() - 1; i += 2) {
            int num = (alphabetLowerCase.inverse().get(text.charAt(i)) * matrix.a +
                    alphabetLowerCase.inverse().get(text.charAt(i + 1)) * matrix.b) % alphabetLength;
            stringBuilder.append(alphabetLowerCase.get(num));
            int num1 = (alphabetLowerCase.inverse().get(text.charAt(i)) * matrix.c +
                    alphabetLowerCase.inverse().get(text.charAt(i + 1)) * matrix.d) % alphabetLength;
            stringBuilder.append(alphabetLowerCase.get(num1));
        }
        return stringBuilder.toString();
    }

    public String decrypt(String text) {
        if (text.length() % 2 != 0) {
            text += "_";
        }
        text = text.replaceAll("\\s+", "_").toLowerCase();
        StringBuilder stringBuilder = new StringBuilder(text.length());
        for (int i = 0; i < text.length() - 1; i += 2) {
            int num = (alphabetLowerCase.inverse().get(text.charAt(i)) * inverseMatrix.a +
                    alphabetLowerCase.inverse().get(text.charAt(i + 1)) * inverseMatrix.b) % alphabetLength;
            stringBuilder.append(alphabetLowerCase.get(num));
            int num1 = (alphabetLowerCase.inverse().get(text.charAt(i)) * inverseMatrix.c +
                    alphabetLowerCase.inverse().get(text.charAt(i + 1)) * inverseMatrix.d) % alphabetLength;
            stringBuilder.append(alphabetLowerCase.get(num1));
        }
        return stringBuilder.toString();
    }
}
