package com.magnet;

import java.util.ArrayList;
import java.util.List;

public class someReversedWords {
    public static void main(String[] args) {
        System.out.println(spinWords("This ecnetnes is a ecnetnes"));
    }

    public static String spinWords(String sentence) {
        String [] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        StringBuilder finalBuilder = new StringBuilder();
        for(int i = 0;i < words.length;i++){
            if(words[i].length() >= 5){
                builder.append(words[i]).reverse();
                words[i] = builder.toString();
                builder.setLength(0);
            }
        }

        for(int i = 0;i < words.length;i++){
            if(i != words.length-1){
                finalBuilder.append(words[i] + " ");
            }
            else{
                finalBuilder.append(words[i]);
            }
        }

        return finalBuilder.toString();
    }

    /******SOMEONE ELSE'S SOLUTION*****/
//    public String spinWords(String sentence) {
//        String[] words = sentence.split(" ");
//        for (int i=0; i<words.length; i++) {
//            if (words[i].length() >= 5) {
//                words[i] = new StringBuilder(words[i]).reverse().toString();
//            }
//        }
    /***The String.join() method concatenates the given elements with the delimiter and returns the concatenated string.***/
//        return String.join(" ",words);
//    }
}
