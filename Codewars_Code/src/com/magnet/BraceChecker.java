package com.magnet;

//Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.
//        This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!
//        All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.


//Examples
//"(){}[]"   =>  True
//"([{}])"   =>  True
//"(}"       =>  False
//"[(])"     =>  False
//"[({})](]" =>  False


import java.util.*;

public class BraceChecker {
    public static void main(String[] args) {
        System.out.println(isValid("[(])"));
//        isValid("(){}[]");

    }

    public static boolean isValid(String braces) {
        Stack<Character> myStack = new Stack<>();
        boolean isVal = false;
        for(int i = 0;i < braces.length();i++){
            char c = braces.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                myStack.push(c);
            }
            else if(!myStack.isEmpty()){
                if (((c == ')' && myStack.peek() == '(') || (c == '}' && myStack.peek() == '{') || (c == ']' && myStack.peek() == '['))) {
                    myStack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }

        }
        return myStack.isEmpty();
    }

                        /**OTHER'S SOLUTIONS*/

//                        public boolean isValid(String braces) {
//                            int lengthOfBraces = braces.length();
//                            for(int i = 0; i < lengthOfBraces; i++){
//                                braces = braces.replace("{}", "").replace("[]", "").replace("()", "");
//                            }
//                            return braces.isEmpty();
//                        }

                    /****************************************************************/

//                        public boolean isValid(String braces) {
//                            String b = braces;
//                            System.out.println(braces);
//                            for(int i=0;i<braces.length()/2;i++)
//                            {
//                                b = b.replaceAll("\\(\\)", "");
//                                b = b.replaceAll("\\[\\]", "");
//                                b = b.replaceAll("\\{\\}", "");
//                                if(b.length() == 0)
//                                    return true;
//                            }
//                            return false;
//                        }

}
