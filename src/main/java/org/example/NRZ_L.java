package org.example;
import java.util.ArrayList;
import java.util.List;

public class NRZ_L implements EncodingPlot {

    public List<Double> generateEncoding(String bits, double bitRate) {
        List<Double> signal = new ArrayList<>();
        double lastVal = 0.0;
        for(char bit : bits.toCharArray()) {

            lastVal = (bit=='1') ? 5.0 : -5.0;
            //add the previous value as it is
            for(int i = 0; i<16; i++){
                //duplicate value for smooth plotting
                signal.add(lastVal);
            }

        }

        return signal;
    }

}