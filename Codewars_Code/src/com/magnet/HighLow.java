package com.magnet;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HighLow {
    public static void main(String[] args) {
        System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    public static String highAndLow(String numbers) {

        String newNums [] = numbers.split(" ");

        Integer [] intArray = new Integer[newNums.length];

        for(int i = 0; i < newNums.length;i++){
            intArray[i] = Integer.parseInt(newNums[i]);
        }

        int min = Collections.min(Arrays.asList(intArray));
        int max = Collections.max(Arrays.asList(intArray));

        return max + " " + min;
    }
}
