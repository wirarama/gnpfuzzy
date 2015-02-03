/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpfuzzy;

import static java.lang.Math.exp;
import static java.lang.Math.pow;

/**
 *
 * @author wirarama
 */
public class fuzzy {
    public static double trimf(double x,double a,double b,double c){
        double out;
        if(a<=x && x<=b){
            out = (x-a)/(b-a);
        }else if(b<=x && x<=c){
            out = (x-b)/(c-b);
        }else{
            out = 0;
        }
        return out;
    }
    public static double lowmf(double x,double a,double b){
        double out;
        if(x<=a){
            out = 1;
        }else if(a<=x && x<=b){
            out = (x-a)/(b-a);
        }else{
            out = 0;
        }
        return out;
    }
    public static double highmf(double x,double a,double b){
        double out;
        if(x>=b){
            out = 1;
        }else if(a<=x && x<=b){
            out = (x-a)/(b-a);
        }else{
            out = 0;
        }
        return out;
    }
    public static double gaussmf(double x,double c,double sigma){
        double out = exp(-pow(x-c, 2) / (2 * pow(sigma, 2)));
        return out;
    }
    public static double sigmf(double x,double c,double a){
        double out = 1/(1+exp(-a*(x-c)));
        return out;
    }
    public static double[][] mfbach(double[] x,double[] v,String method){
        double[] out = new double[x.length];
        double[][] data = new double[x.length][2];
        for(int i=0;i<x.length;i++){
            switch(method){
            case("low"):
                out[i] = lowmf(x[i],v[0],v[1]);
                break;
            case("high"):
                out[i] = highmf(x[i],v[0],v[1]);
                break;
            case("tri"):
                out[i] = trimf(x[i],v[0],v[1],v[2]);
                break;
            case("gauss"):
                out[i] = gaussmf(x[i],v[0],v[1]);
                break;
            case("sig"):
                out[i] = sigmf(x[i],v[0],v[1]);
                break;
            }
            data[i][0] = x[i];
            data[i][1] = out[i];
            System.out.println(method+" "+(int)x[i]+" "+out[i]);
        }
        //plot.makeplot1(data,"fuzzy","fuzzyfile","x","y");
        return data;
    }
}