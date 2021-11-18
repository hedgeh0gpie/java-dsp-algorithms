package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
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
