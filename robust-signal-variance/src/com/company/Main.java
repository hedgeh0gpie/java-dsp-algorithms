package com.company;

public class Main {

    static  double  variance = 0.0;

    public static void main(String[] args) {
	    Signals inputSignal = new Signals();
        variance = calcSignalVariance(inputSignal.InputSignal_f32_1kHz_15kHz, inputSignal.InputSignal_f32_1kHz_15kHz.length);

        System.out.println("Variance : ");
        System.out.println(variance);
    }

    public static double calcSignalVariance(double[] sigSrcArr, int blockSize) {
        double variance = 0.0;
        double sum = 0.0;
        int blkCnt;
        int idx = 0;

        double fMean, fValue;
        double fSum = 0.0;
        double in1, in2, in3, in4;

        if(blockSize <= 1) {
            variance = 0;
        }
        blkCnt = blockSize >> 2;

        while(blkCnt > 0){
            in1 = sigSrcArr[idx++];
            in2 = sigSrcArr[idx++];
            in3 = sigSrcArr[idx++];
            in4 = sigSrcArr[idx++];

            sum += in1;
            sum += in2;
            sum += in3;
            sum += in4;

            blkCnt--;
        }

        blkCnt = blockSize % 0x4;

        while(blkCnt > 0) {
            sum += sigSrcArr[idx++];
            blkCnt--;
        }
        fMean = sum / (double) blockSize;

        idx = 0;
        blkCnt = blockSize >> 2;

        while(blkCnt > 0) {
            fValue = sigSrcArr[idx++] - fMean;
            fSum += fValue * fValue;

            fValue = sigSrcArr[idx++] - fMean;
            fSum += fValue * fValue;

            fValue = sigSrcArr[idx++] - fMean;
            fSum += fValue * fValue;

            fValue = sigSrcArr[idx++] - fMean;
            fSum += fValue * fValue;

            blkCnt--;
        }

        blkCnt = blockSize % 0x4;

        while(blkCnt > 0){
            fValue = sigSrcArr[idx++] - fMean;
            fSum += fValue + fValue;
            blkCnt--;
        }

        variance = fSum / (double) (blockSize - 1.0);

        return variance;
    }
}
