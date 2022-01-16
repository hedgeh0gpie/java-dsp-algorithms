package com.company;

public class Main {

    public static void main(String[] args) {
	    double[] testSig = {1, 2, 4, 6, 7, 3, 63, 6, 354, 4, 63, 6, 3, 6, 3, 6, 3, 5543, 6662, 22, 55664, 2242, 25774};
        double[] result = new double[2];

        calcSigMax(testSig, testSig.length, result);

        System.out.println("Max Value : ");
        System.out.println(result[0]);
        System.out.println("Index of Max Value : ");
        System.out.println(result[1]);
    }

    /*
    * Computes the maximum value of an array of data.
    * The function returns both the maximum value and its position within the array.
    * @brief        Maximum value of a floating-point array
    * @param[in]    sigSrcArr the input array
    * @param[in]    blockSize length of the input array
    * @param[out]   resultDestArr maximum value and index returned here
    * @return       none
    */

    public static void calcSigMax (double[] sigSrcArr, int blockSize, double[] resultDestArr) {
        double maxValue1, maxValue2, out;
        double blkCnt, outIndex;
        double count = 0.0;
        int idx = 0;

        outIndex = 0;

        out = sigSrcArr[idx++];

        blkCnt = (blockSize - 1) >> 2;

        while (blkCnt > 0) {
            // Initialize maxVal to the next consecutive values one by one
            maxValue1 = sigSrcArr[idx++];
            maxValue2 = sigSrcArr[idx++];

            if (out < maxValue1) {
                out = maxValue1;
                outIndex = count + 1;
            }
            if (out < maxValue2) {
                out = maxValue2;
                outIndex = count + 2;
            }

            maxValue1 = sigSrcArr[idx++];
            maxValue2 = sigSrcArr[idx++];

            if (out < maxValue1) {
                out = maxValue1;
                outIndex = count + 3;
            }

            if (out < maxValue2) {
                out = maxValue2;
                outIndex = count + 4;
            }

            count += 4;
            blkCnt--;
        }

        blkCnt = (blockSize - 1) % 0x4;
        while (blkCnt > 0) {
            maxValue1 = sigSrcArr[idx++];
            if (out < maxValue1) {
                out = maxValue1;
                outIndex = blockSize - blkCnt;
            }
            blkCnt--;
        }
        resultDestArr[0] = out;
        resultDestArr[1] = outIndex;
    }


}
