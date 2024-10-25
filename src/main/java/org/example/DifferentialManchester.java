package org.example;
import java.util.ArrayList;
import java.util.List;

public class DifferentialManchester implements EncodingPlot {

    public List<Double> generateEncoding(String bits, double bitRate) {
        List<Double> signal = new ArrayList<>();
        double lastVal = 0.0;
        for(char bit : bits.toCharArray()) {
            // flip the last bit for transition at the beginning
            signal.add(1-lastVal);
            lastVal = signal.get(signal.size()-1);

            for(int i = 0; i<7; i++){
                //duplicate last value for smooth plotting
                signal.add(lastVal);
            }

            if(bit=='1') signal.add(lastVal);
            else signal.add(1 - lastVal);
            lastVal = signal.get(signal.size()-1);

            for(int i = 0; i<7; i++){
                //duplicate last value for smooth plotting
                signal.add(lastVal);
            }
            lastVal = signal.get(signal.size()-1);
        }

        toAnalog(signal);
        return signal;
    }

}