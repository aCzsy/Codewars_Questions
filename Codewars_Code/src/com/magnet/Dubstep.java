package com.magnet;

import com.sun.xml.internal.ws.util.StringUtils;

public class Dubstep {
    public static void main(String[] args) {
        System.out.println(SongDecoder("WUBWUBIWUBAMWUBWUBX"));
        System.out.println(SongDecoder("RWUBWUBWUBLWUB"));
        System.out.println(SongDecoder("WUBWUBABCWUB"));
    }

//    Using regular expression, to replace 2 or more white spaces with single space, is also a good solution.
//
//    We are using regex pattern as “\\s+”.
//
//            \s matches a space, tab, new line, carriage return, form feed or vertical tab.
//             + says one or more occurrences.

    public static String SongDecoder (String song)
    {

        String dub = "WUB";
        String newString = "";
        for(int i = 0;i < song.length();i++){
            newString = song.replace(dub," ");
        }

        String finalString = newString.replaceAll("\\s+", " ");

        return finalString.trim();
    }
}
