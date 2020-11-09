package com.magnet;

public class Convert_String_to_camelCase {

    public static void main(String[] args) {
        System.out.println(toCamelCase("the-stealth-warrior"));
        System.out.println(toCamelCase("The_Stealth_Warrior"));
//        toCamelCase("the-stealth-warrior");
    }

    static String toCamelCase(String s){
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length();i++){
            if(sb.charAt(i) == '_' || sb.charAt(i) == '-'){
                sb.deleteCharAt(i);
                sb.replace(i, i+1,String.valueOf(Character.toUpperCase(sb.charAt(i))));
            }
        }
        return sb.toString();
    }
}
