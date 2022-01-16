package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Signals inputSignals = new Signals();
        double[] outputSignal = new double[inputSignals.InputSignal_f32_1kHz_15kHz.length + inputSignals.Impulse_response.length];

        convolution(inputSignals.InputSignal_f32_1kHz_15kHz,
                    outputSignal,
                    inputSignals.Impulse_response,
                    inputSignals.InputSignal_f32_1kHz_15kHz.length,
                    inputSignals.Impulse_response.length);

        try {
            write("output_signal.dat", outputSignal);
            write("input_signal.dat", inputSignals.InputSignal_f32_1kHz_15kHz);
            write("impulse_rsp.dat", inputSignals.Impulse_response);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public static void write(String filename, double[] x) throws IOException {

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));

        for (int i = 0; i < x.length; i++) {
            outputWriter.write(Double.toString(x[i]));
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }

}
