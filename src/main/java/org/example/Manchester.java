package org.example;
import java.util.ArrayList;
import java.util.List;

public class Manchester implements EncodingPlot {

    public List<Double> generateEncoding(String bits, double bitRate) {
        List<Double> signal = new ArrayList<>();
        double lastVal;
        for(char bit : bits.toCharArray()) {
            // flip the last bit for transition at the beginning
            signal.add((double) Character.getNumericValue(bit));
            lastVal = signal.get(signal.size()-1);

            for(int i = 0; i<7; i++){
                //duplicate last value for smooth plotting
                signal.add(lastVal);
            }

            signal.add((double)(1 - Character.getNumericValue(bit)));
            lastVal = signal.get(signal.size()-1);

            for(int i = 0; i<7; i++){
                //duplicate last value for smooth plotting
                signal.add(lastVal);
            }
        }

        //replace 1 by 5 and 0 by -5
        toAnalog(signal);
        return signal;
    }

}