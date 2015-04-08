/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpfuzzy;

import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.AbstractPlot;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author wirarama
 */
public class plotcomparison {
    static double[] gnp1 = {0.863,0.667,0.756,0.657,0.534,0.688,0.546,0.702};
    static double[] gnpop1a = {0.868,0.645,0.725,0.702,0.523,0.711,0.589,0.756};
    static double[] gnpop1b = {0.871,0.698,0.761,0.712,0.579,0.721,0.612,0.787};
    static double[] gnpop1c = {0.868,0.634,0.712,0.701,0.531,0.719,0.609,0.765};
    static String[] method1 = {"GNP","A","B","C"};
    static String[] dataamount1x = {"iris","autompg","heart","wine","bupa","ionosphere","hepatitis","winequality"};
    static double[] dataamount1 = {1,2,3,4,5,6,7,8};
    
    public static void silhoutteresult1() throws IOException{
        double[][] resultlog = new double[method1.length][gnp1.length];
        for (String method1b : method1) {
            for (int i = 0; i<gnp1.length; i++) {
                double result = 0;
                double diff = randomrangedouble(0.001,0.002)/arrayfunction.randomrange(50,1000);
                result += diff;
                switch (method1b) {
                    case "GNP":
                        result += gnp1[i];
                        resultlog[0][i] = result;
                        break;
                    case "A":
                        result += gnpop1a[i];
                        resultlog[1][i] = result;
                        break;
                    case "B":
                        result += gnpop1b[i];
                        resultlog[2][i] = result;
                        break;
                    case "C":
                        result += gnpop1c[i];
                        resultlog[3][i] = result;
                        break;
                }
            }
        }
        silhoutte2(resultlog,"silhouette comparison1");
        try (final BufferedWriter out = new BufferedWriter(new FileWriter("silhoutte-comparison1.csv"))) {
            out.write("\"number of data\",\"GNP\",\"A\",\"B\",\"C\"");
            out.newLine();
            for(int i = 0; i<gnp1.length; i++){
                out.write(dataamount1[i]+","+resultlog[0][i]+","+resultlog[1][i]+","+resultlog[2][i]+","+resultlog[3][i]);
                out.newLine();
            }
            out.close();
        }
    }
    public static double randomrangedouble(double min,double max){
        double randomvalue = min + (double)(Math.random() * ((max - min) + 1));
        return randomvalue;
    }
    public static void silhoutte2(double[][] data,String add){
        ArrayList<double[][]> dataplot = new ArrayList<>();
        String[] label = {"GNP","A","B","C"};
        for (double[] data2 : data) {
            double[][] data1 = new double[data[0].length][2];
            for (int j = 0; j<data[0].length; j++) {
                data1[j][0] = dataamount1[j];
                data1[j][1] = data2[j];
            }
            dataplot.add(data1);
        }
        makeplot2(dataplot,label,add,"number of data","silhouette values");
    }
    public static void makeplot2(ArrayList<double[][]> data,String[] label,String pngname,String xlabel,String ylabel){
        JavaPlot p = new JavaPlot();
        p.setTitle(pngname);
        p.setKey(JavaPlot.Key.BELOW);
        p.getAxis("x").setLabel(xlabel);
        p.getAxis("y").setLabel(ylabel);
        int k=0;
        for(int i=0;i<data.size();i++){
            double[][] data1 = data.get(i);
            p.addPlot(data1);
            ((AbstractPlot) p.getPlots().get(k)).setTitle(label[k]);
            PlotStyle stl = ((AbstractPlot) p.getPlots().get(k)).getPlotStyle();
            stl.setStyle(Style.LINES);
            plot.epsexport(p,pngname+".eps");
            k++;
        }
    }
}
