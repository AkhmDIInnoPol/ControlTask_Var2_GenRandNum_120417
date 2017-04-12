package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        DigitalGenerator digitalGenerator = new DigitalGenerator();
        PrintEvery_5Sec printEvery_5Sec = new PrintEvery_5Sec();

        digitalGenerator.start();
        printEvery_5Sec.start();


    }
}
