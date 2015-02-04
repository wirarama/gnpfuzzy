/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpfuzzy;

import net.jodk.lang.FastMath;

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
        double out = FastMath.exp(-FastMath.pow(x-c, 2) / (2 * FastMath.pow(sigma, 2)));
        return out;
    }
    public static double gaussprodmf(double x,double c1,double sigma1,double c2,double sigma2){
        int xLEa = operation.isLE(x,c1) ? 1 : 0;
        double a = FastMath.exp(-FastMath.pow(x-c1, 2) / (2 * FastMath.pow(sigma1, 2)))* xLEa + (1 - xLEa);
        int xGEb = operation.isGE(x,c2) ? 1 : 0;
        double b = FastMath.exp(-FastMath.pow(x-c2, 2) / (2 * FastMath.pow(sigma2, 2)))* xGEb + (1 - xGEb);
        double out = a*b;
        return out;
    }
    public static double sigmf(double x,double c,double a){
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        double out = 1/(1+FastMath.exp(-a*(x-c)));
        return out;
    }
    public static double sigprodmf(double x,double c1,double a1,double c2,double a2){
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        double a = 1/(1+FastMath.exp(-a1*(x-c1)));
        double b = 1/(1+FastMath.exp(-a2*(x-c2)));
        return FastMath.abs(a - b);
    }
    public static double[][] mfbach(double[] x,double[] v,String method,String name){
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
            case("gaussprod"):
                out[i] = gaussprodmf(x[i],v[0],v[1],v[2],v[3]);
                break;
            case("sig"):
                out[i] = sigmf(x[i],v[0],v[1]);
                break;
            case("sigprod"):
                out[i] = sigprodmf(x[i],v[0],v[1],v[2],v[3]);
                break;
            }
            data[i][0] = x[i];
            data[i][1] = out[i];
            System.out.println(name+" "+(int)x[i]+" "+out[i]);
        }
        plot.makeplot1(data,"fuzzy",name,"x","y");
        return data;
    }
    

}