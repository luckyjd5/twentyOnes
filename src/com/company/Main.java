package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int countNum = randGen(30,20);
        boolean valid = false;
        String lost = "";
        int userNumRem = 0;
        System.out.println("Starting number is " + countNum);
        while (countNum > 0) {
            try {
                System.out.println("Enter 1, 2, or 3 to remove from " + countNum);
                userNumRem = Integer.parseInt(input());
                if (userNumRem > 0 && userNumRem < 4) {
                    valid = true;
                }
                else {
                    System.out.println("Please enter a valid input");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid input");
            }
            if (valid == true) {
                countNum -= userNumRem;
                System.out.println("You removed " + userNumRem + "\nNumber now " + countNum);
                if (countNum <= 0) {
                    lost = "User";
                    break;
                }
                int compRem = randGen(3,1);
                countNum -= compRem;
                System.out.println("Computer removed " + compRem + "\nNumber now " + countNum);
            }
        }
        if (lost == "User") {
            System.out.println("You lost!");
        }
        else {
            System.out.println("You won!");
        }
    }
    public static String input() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }
    public static int randGen(int max, int min) {
        Random rand = new Random();
        return (rand.nextInt(max-min+1) + min);
    }
}
