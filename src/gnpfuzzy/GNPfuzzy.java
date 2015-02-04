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
        String[] label = {"gaussmf1","gaussmf2","sigmf1","sigmf2"};
        double[] var1 = {20,10};
        double[][] f1 = fuzzy.mfbach(arrayfunction.bachsort(1,100),var1,"gauss",label[0]);
        double[] var2 = {60,20,60,5};
        double[][] f2 = fuzzy.mfbach(arrayfunction.bachsort(1,100),var2,"gaussprod",label[1]);
        double[] var3 = {80,0.2};
        double[][] f3 = fuzzy.mfbach(arrayfunction.bachsort(1,100),var3,"sig",label[2]);
        double[] var4 = {30,0.5,80,0.2};
        double[][] f4 = fuzzy.mfbach(arrayfunction.bachsort(1,100),var4,"sigprod",label[3]);
        ArrayList<double[][]> dataplot = new ArrayList<>();
        dataplot.add(f1);
        dataplot.add(f2);
        dataplot.add(f3);
        dataplot.add(f4);
        plot.makeplot2(dataplot,label,"fuzzy","data","fuzzy membership");
    }
}
