package org.example;
import java.util.ArrayList;
import java.util.List;

public class NRZ_I implements EncodingPlot {

    public List<Double> generateEncoding(String bits, double bitRate) {
        List<Double> signal = new ArrayList<>();
        double lastVal = 0.0;
        for(char bit : bits.toCharArray()) {

            //add the previous value as it is
            for(int i = 0; i<8; i++){
                //duplicate value for smooth plotting
                signal.add(lastVal);
            }

            if(bit=='1') signal.add(5-lastVal);
            else signal.add(lastVal);
            lastVal = signal.get(signal.size()-1);

            for(int i = 0; i<7; i++){
                //duplicate value for smooth plotting
                signal.add(lastVal);
            }

        }

        return signal;
    }

}