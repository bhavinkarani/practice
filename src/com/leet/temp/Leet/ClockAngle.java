package com.leet.temp.Leet;

public class ClockAngle {

    public static void main(String args[]){
        double res = angleClock(3,15);
        System.out.println(res);
        res = angleClock(12,30);
        System.out.println(res);
        res = angleClock(12,0);
        System.out.println(res);

        res = angleClock(3,30);
        System.out.println(res);
        res = angleClock(1,57);
        System.out.println(res);

    }

    private static double angleClock(int hour, int minute) {
        hour = hour %12;
        double angleByEveryHourForHourHand = 30;
        double angleByMinuteForMinuteHand = 6;
        double angleByEveryMinuteForHourHand = 0.5;

        double angleOfHourHand = (hour*angleByEveryHourForHourHand) + (angleByEveryMinuteForHourHand*minute);
        double angleOfMinuteHand =  angleByMinuteForMinuteHand*minute;
        double angle =Math.abs(angleOfHourHand - angleOfMinuteHand);
        if(angle > 180){
            angle = 360-angle;
        }
        return angle;
    }
}
