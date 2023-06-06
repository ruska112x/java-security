package com.karabalin;

import com.karabalin.problems.AffineCipher;
import com.karabalin.problems.CaesarCipher;
import com.karabalin.problems.FrequencyAttack;

public class Main {
    public static void main(String[] args)
    {
        FrequencyAttack frequencyAttack = new FrequencyAttack();
        frequencyAttack.attack();
    }
}