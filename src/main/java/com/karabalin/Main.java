package com.karabalin;

import com.karabalin.problems.AffineCipher;
import com.karabalin.problems.CaesarCipher;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        CaesarCipher caesarCipher = new CaesarCipher();
        System.out.println(caesarCipher.encrypt("Hello world!AZ", 13));
        System.out.println(caesarCipher.decrypt("Uryyb jbeyq!NM", 13));
        AffineCipher affineCipher = new AffineCipher();
        System.out.println(affineCipher.encrypt("Hello World!"));
        System.out.println(affineCipher.decrypt("Hyttc Acltv!"));
    }
}