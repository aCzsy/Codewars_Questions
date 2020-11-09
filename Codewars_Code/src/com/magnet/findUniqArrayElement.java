package com.magnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class findUniqArrayElement {
    public static void main(String[] args) {
        double [] array = {1,1,8,4,4,5,5,4,4};
        System.out.println(findUniq(array));
    }
    public static double findUniq(double arr[]) {
        int val = 1;
        double foundIndex = 0;
        Map<Double,Integer> list = new HashMap<>();

        for(int i = 0;i < arr.length;i++){
            if(list.containsKey(arr[i])){
                list.put(arr[i],list.get(arr[i])+1);
            }
            else{
                list.put(arr[i],val);
            }
        }

        for(Double index : list.keySet()){
            if(list.get(index) == 1){
                foundIndex = index;
            }
        }

        return foundIndex;
    }
}
