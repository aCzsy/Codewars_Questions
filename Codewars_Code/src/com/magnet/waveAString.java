package com.magnet;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class waveAString {
    public static void main(String[] args) {
        String [] check = wave("codewars");

        for(int i = 0;i < check.length;i++){
            System.out.println(check[i] + " ");
        }
        char c = '1' + '3';
        System.out.println(c);
    }

    public static String[] wave(String str) {

        List<String> finalList = new ArrayList<>();
        int firstIndex = 0;
        int loopIndex = 1;

        for(int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            if (c != ' ') {
                String preCapital = str.substring(0,firstIndex);
                String output = str.substring(firstIndex,loopIndex).toUpperCase();
                String out = preCapital + output + str.substring(loopIndex,str.length());
                finalList.add(out);
                loopIndex++;
                firstIndex++;
            }
            else{
                firstIndex++;
                loopIndex++;
            }
        }

        String [] finalArray = finalList.toArray(new String[finalList.size()]);
        System.out.println(finalArray.length);

        return finalArray;
    }
}
