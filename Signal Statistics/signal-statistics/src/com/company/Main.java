package com.company;

public class Main {

    static double mean = 0.0;
    static double variance = 0.0;
    static double std = 0.0;

    // Funkiness with instance and static referencing that needs to be addressed.
    public static void main(String[] args) {
	Signals inputSignal = new Signals();
	SignalStatistics sigStats = new SignalStatistics();

    sigStats.sigSrcArr = inputSignal.InputSignal_f32_1kHz_15kHz;
    sigStats.sigLength = inputSignal.InputSignal_f32_1kHz_15kHz.length;

        System.out.println("Standard Deviation : ");
        System.out.println(sigStats.calcSignalStandardDeviation());
        System.out.println();

        System.out.println("Variance : ");
        System.out.println(sigStats.calcSignalVariance());
        System.out.println();

        System.out.println("Mean : ");
        System.out.println(sigStats.calcSignalMean());
        System.out.println();
    }





}
