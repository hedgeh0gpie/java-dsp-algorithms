package com.company;

public class Main {
    static double mean;

    public static void main(String[] args) {
	    Signals inputSignal = new Signals();

        mean = calcSignalMean(inputSignal.InputSignal_f32_1kHz_15kHz, inputSignal.InputSignal_f32_1kHz_15kHz.length);

        System.out.println("Mean : ");
        System.out.println(mean);
    }

    public static double calcSignalMean(double[] sigSrcArr, int blockSize) {
        double mean = 0.0;
        double sum = 0.0;
        int blkCnt;     // loop counter
        int idx = 0;

        double in1, in2, in3, in4;

        blkCnt = blockSize >> 2;    // blkCnt = blockSize / 4

        // Compute 4 outputs at a time
        while(blkCnt > 0) {
            // C = a[0] + a[1] + a[2] + ... + a[blockSize - 1]

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
        // C = (a[0] + a[1] + a[2] + ... + a[blockSize - 1]) / blockSize
        // Store the result to the destination

        mean = sum / (double)blockSize;
        return mean;
    }
}
