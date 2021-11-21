package com.company;

public class Main {


    static double mean = 0.0;
    static double variance = 0.0;

//    private static final int SIG_LENGTH = 320;

    public static void main(String[] args) {
	Signals inputSignal = new Signals();

	// Two ways to do this. Pass in SIG_LENGTH or pass in the length of the array
        //	mean = calcSignalMean(inputSignal.InputSignal_f32_1kHz_15kHz, SIG_LENGTH);
	mean = calcSignalMean(inputSignal.InputSignal_f32_1kHz_15kHz, inputSignal.InputSignal_f32_1kHz_15kHz.length);

	variance = calcSignalVariance(inputSignal.InputSignal_f32_1kHz_15kHz, mean, inputSignal.InputSignal_f32_1kHz_15kHz.length);


        System.out.println("Variance : ");
        System.out.println(variance);
    }

    // Version focused on code readability
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
}
