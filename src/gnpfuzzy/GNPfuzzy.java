/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpfuzzy;

import java.util.ArrayList;

/**
 *
 * @author wirarama
 */
public class GNPfuzzy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] var1 = {20,10};
        double[][] f1 = fuzzy.mfbach(arrayfunction.bachsort(1,100),var1,"gauss");
        double[] var2 = {50,20};
        double[][] f2 = fuzzy.mfbach(arrayfunction.bachsort(1,100),var2,"gauss");
        double[] var3 = {40,20};
        double[][] f3 = fuzzy.mfbach(arrayfunction.bachsort(1,100),var3,"sig");
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(f1);
        dataplot.add(f2);
        dataplot.add(f3);
        String[] label = {"f1","f2","f3"};
        plot.makeplot2(dataplot,label,"fuzzy","data","fuzzy membership");
    }
}
