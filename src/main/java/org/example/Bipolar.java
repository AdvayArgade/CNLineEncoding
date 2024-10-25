package org.example;
import java.util.ArrayList;
import java.util.List;

public class Bipolar implements EncodingPlot {

    public List<Double> generateEncoding(String bits, double bitRate) {
        List<Double> signal = new ArrayList<>();
        double lastVal;
        double lastLevel = 5.0;
        for(char bit : bits.toCharArray()) {
            // 0 remains 0, 1 becomes 5 ot -5 depending on lastLevel
            signal.add(lastLevel * Character.getNumericValue(bit));
            lastVal = signal.get(signal.size()-1);
            if(bit=='1') lastLevel = -lastLevel;

            for(int i = 0; i<15; i++){
                //duplicate last value for smooth plotting
                signal.add(lastVal);
            }

        }

        return signal;
    }

}