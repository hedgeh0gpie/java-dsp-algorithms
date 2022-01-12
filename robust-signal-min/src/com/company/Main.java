package com.company;

public class Main {

    public static void main(String[] args) {
        double[] testSignal = {1002, 34, 234, 342, 51, 7, 2, 87, 2356, 134, 667, 2323};
        double[] result = new double[2];

        calcSignMin(testSignal, testSignal.length, result);

        System.out.println("Min Value : ");
        System.out.println(result[0]);

        System.out.println("Index of Min Value : ");
        System.out.println(result[1]);
    }

    /*
     * Computes the minimum value of an array of data.
     * The function returns both the minimum value and its position within the array.
     * @brief        Minimum value of a floating-point array
     * @param[in]    sigSrcArr to the input array
     * @param[in]    blockSize length of the input array
     * @param[out]   resultDestArr minimum value and index returned here
     * @return       none
     */

    public static void calcSignMin(double[] sigSrcArr, int blockSize, double[] resultDestArr) {

        double minValue1 = 0;
        double minValue2 = 0;
        double out;
        int blkCnt, outIndex, count;
        int idx = 0;
        count = 0;
        outIndex = 0;
        out = sigSrcArr[idx++];

        blkCnt = (blockSize - 1) >> 2;

        while (blkCnt > 0) {
            minValue1 = sigSrcArr[idx++];
            minValue2 = sigSrcArr[idx++];


            if (out > minValue1) {
                out = minValue1;
                outIndex = count + 1;
            }

            if (out > minValue2) {
                out = minValue2;
                outIndex = count + 2;
            }

            minValue1 = sigSrcArr[idx++];
            minValue2 = sigSrcArr[idx++];

            if (out > minValue1) {
                out = minValue1;
                outIndex = count + 3;
            }

            if (out > minValue2) {
                out = minValue2;
                outIndex = count + 4;
            }

            count += 4;
            blkCnt--;
        }

        blkCnt = (blockSize - 1) % 4;

        while (blkCnt > 0) {
            minValue1 = sigSrcArr[idx++];

            if (out > minValue1) {
                out = minValue1;
                outIndex = blockSize - blkCnt;
            }
            blkCnt--;
        }
        resultDestArr[0] = out;
        resultDestArr[1] = outIndex;
    }
}
