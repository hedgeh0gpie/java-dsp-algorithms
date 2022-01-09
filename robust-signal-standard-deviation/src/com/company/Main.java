package com.company;

public class Main {

    static double std = 0.0;

    public static void main(String[] args) {
        Signals inputSignal = new Signals();

        std = calcSignalStandardDeviation(inputSignal.InputSignal_f32_1kHz_15kHz, inputSignal.InputSignal_f32_1kHz_15kHz.length);

        System.out.println("Standard Deviation : ");
        System.out.println(std);
    }

    public static double calcSignalStandardDeviation(double[] sigSrcArr, int blockSize) {
        double std;
        double sum = 0.0;
        int blkCnt;
        int idx = 0;

        double sumOfSquares = 0.0;
        double in;
        double meanOfSquares, mean, squareOfMean;
        double squareOfSum;
        double var;

        if (blockSize == 1){
            std = 0;
        }

        blkCnt = blockSize >> 2;

        while (blkCnt > 0) {
            in = sigSrcArr[idx++];
            sum += in;
            sumOfSquares += in * in;
            in = sigSrcArr[idx++];
            sum += in;
            sumOfSquares += in * in;
            in = sigSrcArr[idx++];
            sum += in;
            sumOfSquares += in * in;
            in = sigSrcArr[idx++];
            sum += in;
            sumOfSquares += in * in;

            blkCnt--;
        }

        blkCnt = blockSize % 0x4;

        while (blkCnt > 0) {
            in = sigSrcArr[idx++];
            sum += in;
            sumOfSquares += in * in;
            blkCnt--;
        }

        meanOfSquares = sumOfSquares / (double) (blockSize - 1.0);

        mean = sum / (double) blockSize;

        squareOfMean = (mean * mean) * ((double) blockSize) / ((double) blockSize - 1.0);

        std = Math.sqrt((meanOfSquares - squareOfMean));

        while (blkCnt > 0) {
            in = sigSrcArr[idx++];
            sumOfSquares += in * in;
            sum += in;
            blkCnt--;
        }

        squareOfSum = (sum * sum) / (double) blockSize;

        var = (sumOfSquares - squareOfSum) / (blockSize - 1.0);

        std = Math.sqrt(var);

        return std;

    }
}
