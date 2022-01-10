package com.company;

public class Main {
    static double rms = 0.0;

    public static void main(String[] args) {
	    Signals inputSignal = new Signals();
        rms = calcSignalRMS(inputSignal.InputSignal_f32_1kHz_15kHz, inputSignal.InputSignal_f32_1kHz_15kHz.length);

        System.out.println("RMS : ");
        System.out.println(rms);
    }

    // Calculates the root mean square of the elements in an array

    public static double calcSignalRMS(double[] sigSrcArr, int blockSize) {
        double rms;
        double sum = 0.0;
        int blkCnt;
        int idx = 0;
        double in;

        blkCnt = blockSize >> 2;

        // First part of the processing with loop unrolling. Compute 4 outputs at a time.
        // A second loop below computes the remaining 1 to 3 samples.
        while (blkCnt > 0) {
            // C = A[0] * A[0] + A[1] * A[1] + A[2] * A[2] + ... + A[blockSize - 1] * A[blockSize - 1]
            // Compute sum of the squares and then store the result in a temporary variable, sum

            in = sigSrcArr[idx++];
            sum += in * in;

            in = sigSrcArr[idx++];
            sum += in * in;

            in = sigSrcArr[idx++];
            sum += in * in;

            in = sigSrcArr[idx++];
            sum += in * in;

            blkCnt--;
        }

        // If the blockSize is not a multiple of 4, compute any remaining output samples here.
        // No loop unrolling is used.

        blkCnt = blockSize % 0x4;

        while (blkCnt > 0) {
            in = sigSrcArr[idx++];
            sum += in * in;
            blkCnt--;
        }
        rms = Math.sqrt(sum / (double) blockSize);

        return rms;
    }
}
