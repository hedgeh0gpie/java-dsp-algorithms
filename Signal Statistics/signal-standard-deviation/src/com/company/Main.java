package com.company;

public class Main {

    static double mean = 0.0;
    static double variance = 0.0;
    static double std = 0.0;

    public static void main(String[] args) {
	Signals inputSignal = new Signals();

	mean = calcSignalMean(inputSignal.InputSignal_f32_1kHz_15kHz, inputSignal.InputSignal_f32_1kHz_15kHz.length);

	variance = calcSignalVariance(inputSignal.InputSignal_f32_1kHz_15kHz, mean, inputSignal.InputSignal_f32_1kHz_15kHz.length);

	std = calcSignalStandardDeviation(variance);

        System.out.println("Standard Deviation : ");
        System.out.println(std);
    }


    public static double calcSignalMean(double[] sigSrcArr, int sigLength) {
        double mean = 0.0;
        for(int i = 0; i < sigLength; i++) {
            mean = mean + sigSrcArr[i];
        }
        mean = mean / (double) sigLength;
        return mean;
    }

    public static double calcSignalVariance(double[] sigSrcArr, double sigMean, int sigLength) {
        double variance = 0.0;
        for(int i = 0; i < sigLength; i++) {
            variance = variance + Math.pow((sigSrcArr[i] - sigMean), 2);
        }

        variance = variance / (sigLength - 1);

        return variance;
    }

    public static double calcSignalStandardDeviation(double sigVariance) {
        return Math.sqrt(sigVariance);
    }
}
