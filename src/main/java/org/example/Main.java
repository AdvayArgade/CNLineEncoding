package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EncodingPlot encodingPlot = new NRZ_L();
        String input = "1010011";
        List<Double> signal =  encodingPlot.generateEncoding(input, 10);
        System.out.println(signal);
        try{
            encodingPlot.plotSignal(signal, "Polar NRZ (NRZ-L)", input);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}