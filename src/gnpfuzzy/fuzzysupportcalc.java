/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpfuzzy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author wirarama
 */
public class fuzzysupportcalc {
    public static void test(int x,int y) throws IOException{
        try (BufferedWriter out = new BufferedWriter(new FileWriter("data.csv"))) {
            double[][] fuzzy = new double[x][y+1];
            for(int i=0;i<y;i++){
                for(int j=0;j<x;j++){
                    fuzzy[j][i] = arrayfunction.randomrange((double)0,(double)100)/100;
                    out.write(fuzzy[j][i]+",");
                    
                }
                out.newLine();
            }
            double[] sums = new double[x];
            for(int k=0;k<x;k++){
                sums[k]=0;
                for(int l=0;l<y;l++){
                    sums[k]+=fuzzy[k][l];
                }
                out.write(sums[k]+",");
            }
            out.close();
        }
    }
}
