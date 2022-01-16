package com.company;

public class Main {


    static double mean = 0.0;
    private static final int SIG_LENGTH = 320;

    public static void main(String[] args) {
	Signals inputSignal = new Signals();

	// Two ways to do this. Pass in SIG_LENGTH or pass in the length of the array
//	calcSignalMean(inputSignal.InputSignal_f32_1kHz_15kHz, inputSignal.InputSignal_f32_1kHz_15kHz.length);
	mean = calcSignalMean(inputSignal.InputSignal_f32_1kHz_15kHz, SIG_LENGTH);
        System.out.println("Mean : ");
        System.out.println(mean);
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
}
