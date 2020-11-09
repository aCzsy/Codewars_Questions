package com.magnet;

import com.sun.xml.internal.ws.util.StringUtils;

public class Dubstep {
    public static void main(String[] args) {
        System.out.println(SongDecoder("WUBWUBIWUBAMWUBWUBX"));
        System.out.println(SongDecoder("RWUBWUBWUBLWUB"));
        System.out.println(SongDecoder("WUBWUBABCWUB"));
    }

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
