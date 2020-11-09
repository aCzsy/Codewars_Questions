package com.magnet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findEvenIndex {

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,0,1};
        System.out.println(findEvenIndex(array));
    }
    public static int findEvenIndex(int[] arr) {
        int result = -1;
        for (int i = 0; i <= arr.length - 1; i++) {
            int[] left = new int[i], right = new int[(arr.length - 1) - i];
            System.arraycopy(arr, 0, left, 0, i);
            System.arraycopy(arr, i + 1, right, 0, (arr.length - 1) - i);
            if (getSumOfArray(left) == getSumOfArray(right)) {
                result = i;
            }
        }
        return result;

    }

    private static int getSumOfArray (int[] arr) {
        Integer sum = 0;
        for(int i = 0; i < arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }

    private static void printArray(int [] arr){
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}
