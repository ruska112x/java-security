package com.karabalin.problems;

import com.google.common.collect.HashBiMap;

public class CaesarCipher {
    private HashBiMap<Integer, Character> alphabetLowerCase;
    private HashBiMap<Integer, Character> alphabetUpperCase;

    private int alphabetLength = 0;

    public CaesarCipher() {
        alphabetLowerCase = HashBiMap.create();
        alphabetUpperCase = HashBiMap.create();
        alphabetLength = 26;
        int i = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetLowerCase.put(i, c);
            alphabetUpperCase.put(i, Character.toUpperCase(c));
            i++;
        }
    }

    public String encrypt(String string, int shift) {
        shift %= alphabetLength;
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (char c : string.toCharArray()) {
            if (alphabetLowerCase.containsValue(c)) {
                int cc = ((alphabetLowerCase.inverse().get(c) + shift) % alphabetLength);
                stringBuilder.append(alphabetLowerCase.get(cc));
            } else if (alphabetUpperCase.containsValue(c)) {
                int cc = ((alphabetUpperCase.inverse().get(c) + shift) % alphabetLength);
                stringBuilder.append(alphabetUpperCase.get(cc));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public String decrypt(String string, int shift) {
        shift %= alphabetLength;
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (char c : string.toCharArray()) {
            if (alphabetLowerCase.containsValue(c)) {
                int cc = ((alphabetLowerCase.inverse().get(c) - shift + alphabetLength) % alphabetLength);
                stringBuilder.append(alphabetLowerCase.get(cc));
            } else if (alphabetUpperCase.containsValue(c)) {
                int cc = ((alphabetUpperCase.inverse().get(c) - shift + alphabetLength) % alphabetLength);
                stringBuilder.append(alphabetUpperCase.get(cc));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
