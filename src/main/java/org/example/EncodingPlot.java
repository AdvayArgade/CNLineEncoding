package org.example;

import com.github.sh0nk.matplotlib4j.Plot;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

interface EncodingPlot{
    List<Double> generateEncoding(String bits, double bitRate);

    default void toAnalog(List<Double> signal){
        for (ListIterator<Double> iter = signal.listIterator(); iter.hasNext(); ) {
            Double element = iter.next();
            if ((element == 1)) {
                iter.set(5.0);
            } else {
                iter.set(-5.0);
            }
        }
    }

    default void plotSignal(List<Double> signal, String type, String bits) throws Exception {
        List<Double> time = new ArrayList<>();
        for (int i = 0; i < signal.size(); i++) {
            time.add(i / 16.0);  // 4 samples per bit period
        }

        Plot plt = Plot.create();
        plt.plot().add(time, signal).label(type + " Encoding").linestyle("-");
        plt.xlabel("Time");
        plt.ylabel("Signal");
        plt.title(type + " Encoding Plot");
        for(int i = 0; i<bits.length(); i++){
            plt.text(i+0.5, 0, bits.substring(i, i+1));
        }
        plt.show();
    }
}
