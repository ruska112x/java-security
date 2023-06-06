package com.karabalin.problems;

import com.google.common.collect.HashBiMap;
import org.checkerframework.checker.units.qual.A;

import java.sql.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FrequencyAttack {
    private HashBiMap<Integer, Character> alphabetLowerCase;
    private HashBiMap<Integer, Character> alphabetUpperCase;
    private int alphabetLength = 0;

    private int numOfE = 4;
    private int numOfT = 19;

    private int[] mostCommon = {4, 19, 0, 14, 8, 13, 18};

    public FrequencyAttack() {
        alphabetLength = 26;
        alphabetLowerCase = HashBiMap.create();
        alphabetUpperCase = HashBiMap.create();
        int i = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetLowerCase.put(i, c);
            alphabetUpperCase.put(i, Character.toUpperCase(c));
            i++;
        }
    }

    private Character[] getFreqChars(String text) {
        HashMap<Character, Long> freq = text.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
        ArrayList<Long> sortedNums = new ArrayList<>(freq.values().stream().toList());
        Collections.sort(sortedNums, new Comparator<Long>() {
            @Override
            public int compare(Long aLong, Long t1) {
                return -aLong.compareTo(t1);
            }
        });
        ArrayList<Character> sortedChars = new ArrayList<>();
        for (Long l : sortedNums) {
            for (Map.Entry<Character, Long> entry : freq.entrySet()) {
                if (entry.getValue().equals(l)) {
                    if (!sortedChars.contains(entry.getKey())) {
                        sortedChars.add(entry.getKey());
                    }
                }
            }
        }
        Character[] chars = new Character[sortedChars.toArray().length];
        sortedChars.toArray(chars);
        return chars;
    }

    public void attack() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = scanner.nextLine();
        Character[] freqChars = getFreqChars(text);
        System.out.println(Arrays.stream(freqChars).toList());
    }
}
