/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gnpfuzzy;

/**
 *
 * @author wirarama
 */
public class arrayfunction {
    public static double randomrange(double min,double max){
        double randomvalue = min + (int)(Math.random() * ((max - min) + 1));
        return randomvalue;
    }
    public static double[] randomrangebach(int x,double min,double max){
        double[] out = new double[x];
        for(int i=0;i<x;i++){
            out[i] = randomrange(min,max);
        }
        return out;
    }
    public static double[] randomrangebachsort(double start,double end,double min,double max){
        double[] out = new double[1000];
        out[0] = start;
        int i = 1;
        while(start<end){
            out[i] = start+randomrange(min,max);
            if(out[i]>end) out[i]=end; 
            start = out[i];
            i++;
        }
        double[] out1 = cleanarray(out,i);
        return out1;
    }
    public static double[] bachsort(int start,int end){
        double[] out = new double[(end-start)+1];
        int j = 0;
        for(int i = start;i<=end;i++){
            out[j] = i;
            j++;
        }
        return out;
    }
    public static double[] bachsort2(double start,double end,int amount){
        double[] out = new double[amount+1];
        double inc = (end-start)/(double)amount;
        int j = 0;
        while(start<=end){
            out[j] = start+inc;
            start = out[j];
            j++;
        }
        return out;
    }
    public static double[] bachsort3(double start,double inc,int amount){
        double[] out = new double[amount];
        out[0] = start;
        int j = 1;
        while(j<amount){
            out[j] = start+inc;
            start = out[j];
            j++;
        }
        return out;
    }
    public static double[] cleanarray(double[] data,int length){
        double[] newdata = new double[length];
        System.arraycopy(data, 0, newdata, 0, length);
        return newdata;
    }
}
