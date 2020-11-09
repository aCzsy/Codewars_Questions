package com.magnet;

public class BouncingBall {
    public static final int FIRST_FALL = 1; // Count 1 when boy drops the ball

    /*count is incremented within the while loop when the ball rebounds,
     * but it also hits the ground same amount of times, so the result is multiplied by GRAVITY,
     * basically the result gets doubled
     */
    public static final int GRAVITY = 2;
    public static void main(String[] args) {
        System.out.println(bouncingBall(3,0.66,1.5));
    }

    public static int bouncingBall(double h, double bounce, double window) {
        if(h <= 0 || ((bounce <= 0) || (bounce >= 1)) || window >= h ){
            return -1;
        }

        int count = 0;
        double bounceCalc;

        while(true){
            bounceCalc = h * bounce;
            if(bounceCalc <= window){
                break;
            }
            count++;
            h = bounceCalc;
        }

        return (count * GRAVITY) + FIRST_FALL;
    }
}
