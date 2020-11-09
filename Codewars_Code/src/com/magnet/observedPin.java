package com.magnet;

//Alright, detective, one of our colleagues successfully observed our target person, Robby the robber.
// We followed him to a secret warehouse, where we assume to find all the stolen stuff. The door to this warehouse is secured by an electronic combination lock.
// Unfortunately our spy isn't sure about the PIN he saw, when Robby entered it.
//
//        The keypad has the following layout:
//
//        ┌───┬───┬───┐
//        │ 1 │ 2 │ 3 │
//        ├───┼───┼───┤
//        │ 4 │ 5 │ 6 │
//        ├───┼───┼───┤
//        │ 7 │ 8 │ 9 │
//        └───┼───┼───┘
//        │ 0 │
//        └───┘
//        He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could actually be another adjacent digit (horizontally or vertically,
//        but not diagonally). E.g. instead of the 1 it could also be the 2 or 4. And instead of the 5 it could also be the 2, 4, 6 or 8.
//
//        He also mentioned, he knows this kind of locks. You can enter an unlimited amount of wrong PINs, they never finally lock the system or sound the alarm.
//        That's why we can try out all possible (*) variations.
//
//        * possible in sense of: the observed PIN itself and all variations considering the adjacent digits
//
//        Can you help us to find all those variations? It would be nice to have a function,
//        that returns an array (or a list in Java and C#) of all variations for an observed PIN with a length of 1 to 8 digits.
//        We could name the function getPINs (get_pins in python, GetPINs in C#). But please note that all PINs,
//        the observed one and also the results, must be strings, because of potentially leading '0's. We already prepared some test cases for you.
//
//        Detective, we are counting on you!

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class observedPin {
    public static void main(String[] args) {
        List<String> l= getPINs("8");
        System.out.println(l);
    }


    public static List<String> getPINs(String observed) {
        HashMap<String, String[]> adjacents = new HashMap<>();
        adjacents.put("1", new String[]{"1", "2", "4"});
        adjacents.put("2", new String[]{"1", "2", "3", "5"});
        adjacents.put("3", new String[]{"2", "3", "6"});
        adjacents.put("4", new String[]{"1", "4", "5", "7"});
        adjacents.put("5", new String[]{"2", "4", "5", "6", "8"});
        adjacents.put("6", new String[]{"3", "5", "6", "9"});
        adjacents.put("7", new String[]{"4", "7", "8"});
        adjacents.put("8", new String[]{"5", "7", "8", "9", "0"});
        adjacents.put("9", new String[]{"6", "8", "9"});
        adjacents.put("0", new String[]{"0", "8"});

        StringBuilder pinBuilder = new StringBuilder(observed);

        char[] observedPin = observed.toCharArray();

        String[] firstPositionValues = adjacents.get(String.valueOf(observedPin[0]));

        List<String> pins = new ArrayList<>();

        for (String value : firstPositionValues) {

            //This outer loop is to set the first value
            pinBuilder.setCharAt(0, value.charAt(0));

            int currentDigit = 1; //Start from the first digit after the first
            int[] currentPermutation = new int[observedPin.length]; //Keeps track of how many potential permutations for a given number

            if (observedPin.length > 1) {

                //Loop through the rest of the pin checking each possible permutation
                while (currentDigit != observedPin.length && currentDigit > 0) {

                    //Get all the possible alternative values for the current digit in the pin
                    String[] values = adjacents.get(String.valueOf(observedPin[currentDigit]));

                    if (currentDigit == observedPin.length - 1) {

                        //if the current permutation is less than the possible values
                        if (currentPermutation[currentDigit] < values.length) {

                            for (String val : values) {

                                pinBuilder.setCharAt(currentDigit, val.charAt(0));

                                if (currentPermutation[currentDigit] < values.length) {
                                    currentPermutation[currentDigit]++;
                                }

                                //Don't add duplicates
                                if (pins.indexOf(pinBuilder.toString()) == -1) {
                                    pins.add(pinBuilder.toString());
                                }

                            }
                        } else {
                            currentPermutation[currentDigit] = 0;
                            currentDigit = currentDigit - 1;
                        }


                    } else {

                        if (currentPermutation[currentDigit] < values.length) {
                            pinBuilder.setCharAt(currentDigit, values[currentPermutation[currentDigit]].charAt(0));
                            currentPermutation[currentDigit]++;
                            currentDigit++;
                        }
                        else {
                            currentPermutation[currentDigit] = 0;
                            currentDigit = currentDigit - 1;
                        }
                    }
                }
            }

            if (pins.indexOf(pinBuilder.toString()) == -1) {
                pins.add(pinBuilder.toString());
            }
        }

        System.out.println("There are : " + pins.size()+  " possible pins");
        return pins;


//        char [] sep = observed.toCharArray();
//        String [] num = observed.split("(?<=.)");
//        String n = "";
//        int i = 0;
//        String [] arr = new String[100];
//        List<Integer> list = new ArrayList<>();
//        List<String> combos = new ArrayList<>();
//
//        while(i < num.length){
//            if(Integer.parseInt(num[i]) - 1 >= 0 && Integer.parseInt(num[i]) - 1 <= 9){
//                n += String.valueOf(Integer.parseInt(num[i]) - 1);
////                combos.add(String.valueOf(Integer.parseInt(num[i]) - 1));
//            }
//            if(Integer.parseInt(num[i]) + 1 >= 0 && Integer.parseInt(num[i]) + 1 <= 9){
//                n += String.valueOf(Integer.parseInt(num[i]) + 1);
////                combos.add(String.valueOf(Integer.parseInt(num[i]) + 1));
//            }
//            if(Integer.parseInt(num[i]) + 3 >= 0 && Integer.parseInt(num[i]) + 3 <= 9){
//                n += String.valueOf(Integer.parseInt(num[i]) + 3);
////                combos.add(String.valueOf(Integer.parseInt(num[i]) + 3));
//            }
//            if(Integer.parseInt(num[i]) - 3 >= 0 && Integer.parseInt(num[i]) - 3 <= 9){
//                n += String.valueOf(Integer.parseInt(num[i]) - 3);
////                combos.add(String.valueOf(Integer.parseInt(num[i]) - 3));
//            }
//            i++;
//            combos.add(n);
//            n = "";
//        }
//
////        System.out.println(n);
//        System.out.println(combos);

    }



}
