package com.karabalin.problems;

import com.google.common.collect.HashBiMap;

import java.util.Map;
import java.util.Scanner;

public class AffineCipher {
    // C = a * P + b
    // P = at * P - b
    private HashBiMap<Integer, Character> alphabetLowerCase;
    private HashBiMap<Integer, Character> alphabetUpperCase;

    private HashBiMap<Integer, Integer> firstKeyElements;
    private int alphabetLength = 0;

    private int a = 0, at = 0, b = 0;

    private int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    private void init() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("All possibles value of a:");
            for (var x : firstKeyElements.keySet()) {
                System.out.print(x + ", ");
            }
            for (var x : firstKeyElements.values()) {
                System.out.print(x + ", ");
            }
            System.out.print("\n");
            System.out.println("Please enter one of these a: ");
            a = scanner.nextInt();
        } while (!firstKeyElements.containsKey(a) && !firstKeyElements.containsValue(a));
        at = firstKeyElements.get(a);
        System.out.println("Please enter value of b: ");
        b = scanner.nextInt();
        b %= alphabetLength;
    }

    public AffineCipher() {
        alphabetLength = 26;
        alphabetLowerCase = HashBiMap.create();
        alphabetUpperCase = HashBiMap.create();
        firstKeyElements = HashBiMap.create();
        int i = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetLowerCase.put(i, c);
            alphabetUpperCase.put(i, Character.toUpperCase(c));
            i++;
        }
        for (i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if ((i * j) % 26 == 1) {
                    if (!firstKeyElements.containsKey(i) && !firstKeyElements.containsValue(i) &&
                            !firstKeyElements.containsKey(j) && !firstKeyElements.containsValue(j)) {
                        firstKeyElements.put(i, j);
                    }
                }
            }
        }
    }

    public String encrypt(String string) {
        init();
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (char c : string.toCharArray()) {
            if (alphabetLowerCase.containsValue(c)) {
                int cc = ((alphabetLowerCase.inverse().get(c) * a + b) % alphabetLength);
                stringBuilder.append(alphabetLowerCase.get(cc));
            } else if (alphabetUpperCase.containsValue(c)) {
                int cc = ((alphabetUpperCase.inverse().get(c) * a + b) % alphabetLength);
                stringBuilder.append(alphabetUpperCase.get(cc));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public String decrypt(String string) {
        init();
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (char c : string.toCharArray()) {
            if (alphabetLowerCase.containsValue(c)) {
                int cc = ((alphabetLowerCase.inverse().get(c)- b + alphabetLength) * at % alphabetLength);
                stringBuilder.append(alphabetLowerCase.get(cc));
            } else if (alphabetUpperCase.containsValue(c)) {
                int cc = ((alphabetUpperCase.inverse().get(c)- b + alphabetLength) * at % alphabetLength);
                stringBuilder.append(alphabetUpperCase.get(cc));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
