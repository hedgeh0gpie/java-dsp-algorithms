package com.company;

public class SignalStatistics {
    public static double[] sigSrcArr;
    public static int sigLength;


    public static double calcSignalMean() {
        double mean = 0.0;
        for(int i = 0; i < sigLength; i++) {
            mean = mean + sigSrcArr[i];
        }
        mean = mean / (double) sigLength;
        return mean;
    }

    public static double calcSignalVariance() {
        double variance = 0.0;
        double sigMean = calcSignalMean();
        for(int i = 0; i < sigLength; i++) {
            variance = variance + Math.pow((sigSrcArr[i] - sigMean), 2);
        }

        variance = variance / (sigLength - 1);

        return variance;
    }

    public static double calcSignalStandardDeviation() {
        double sigVariance = calcSignalVariance();
        return Math.sqrt(sigVariance);
    }

}
