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
public class hellingerdist {
    public static double computeHellingerDist(double P_mean, double P_variance,double Q_mean,double Q_variance){
        double hellinger;
        double P_stdev = FastMath.sqrt(P_variance);
        double Q_stdev = FastMath.sqrt(Q_variance);
        hellinger = 1- FastMath.sqrt((2 * P_stdev * Q_stdev)/(P_variance+Q_variance))* FastMath.exp(-1/4*(FastMath.pow(P_mean-Q_mean, 2) / (P_variance+Q_variance)));
        System.out.println(hellinger);
        return hellinger;
    }
}
