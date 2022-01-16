package com.company;

public class Main {

    public static void main(String[] args) {

    }

    public static void convolution(
            double[] sigSrcArr,
            double[] sigDestArr,
            double[] impResponseArr,
            int sigSrcLength,
            int impResponseLength) {

        int i, j;

        for (i = 0; i < (sigSrcLength + impResponseLength) - 1; i++) {
            sigDestArr[i] = 0;
        }

        for (i = 0; i < sigSrcLength; i++) {
            for (j = 0; j < impResponseLength; j++) {
                sigDestArr[i + j] = sigDestArr[i + j] + sigSrcArr[i] * impResponseArr[j];
            }
        }

    }
}
