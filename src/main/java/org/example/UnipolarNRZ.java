package org.example;
import java.util.ArrayList;
import java.util.List;

public class UnipolarNRZ implements EncodingPlot {

    public List<Double> generateEncoding(String bits, double bitRate) {
        List<Double> signal = new ArrayList<>();
        double lastVal = 0.0;
        for(char bit : bits.toCharArray()) {

            lastVal = 5.0 * Character.getNumericValue(bit);
            //add the previous value as it is
            for(int i = 0; i<16; i++){
                //duplicate value for smooth plotting
                signal.add(lastVal);
            }

        }

        return signal;
    }

}