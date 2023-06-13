package com.karabalin;

import com.karabalin.problems.AffineCipher;
import com.karabalin.problems.CaesarCipher;
import com.karabalin.problems.FrequencyAttack;
import com.karabalin.problems.HillCipher;

public class Main {
    public static void main(String[] args) {
        // FrequencyAttack frequencyAttack = new FrequencyAttack();
        // frequencyAttack.attack();
        // Qnuux! Vh mnja oarnwm, Adbujw! R'en knnw fjwcrwp cx cnuu hxd oxa j uxwp crvn... R cqrwt hxd'an lxxu! Hxd jan mrurpnwc jwm qjamfxatrwp, R anjuuh urtn cqnbn zdjurcrnb rw hxd! Pxxm sxk! Hxd fruu bdllnnm! Kxumuh px jqnjm jwm xw! Jwm mxw'c oxapnc, fn'an luxbn. Xwn qjb xwuh cx bjh, cjut, jwm nenahcqrwp fruu kn anbxuenm!) Mxw'c kn joajrm!

        HillCipher hillCipher = new HillCipher();
        System.out.println(hillCipher.encrypt("help me"));
        System.out.println(hillCipher.decrypt("hiatnkpn"));
    }
}