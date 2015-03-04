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
public class kldiv {
    public static double kldiv(double mu1,double mu2,double sig1,double sig2){
        double out = 0;
        out = FastMath.log10(sig2/sig1)+(FastMath.pow(sig1,2)+FastMath.pow((mu1+mu2),2)/2*FastMath.pow(sig2,2))-1/2;
        System.out.println(out);
        return out;
    }
}
