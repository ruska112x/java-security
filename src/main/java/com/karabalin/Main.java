package com.karabalin;

import com.karabalin.problems.SimpleCaesar;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        SimpleCaesar simpleCaesar = new SimpleCaesar();
        System.out.println(simpleCaesar.encrypt("Hello world!AZ", 13));
    }
}