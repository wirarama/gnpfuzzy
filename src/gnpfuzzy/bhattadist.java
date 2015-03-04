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
public class bhattadist {
    public static double bhattadist(double P_mean, double P_variance,double Q_mean,double Q_variance){
        double bhatta;
        double P_variance1 = Math.pow(P_variance,2);
        double Q_variance1 = Math.pow(Q_variance,2);
        bhatta = 1/4*(Math.log(1/4*((P_variance1/Q_variance1)+(Q_variance1/P_variance1)+2)))+
                1/4*(Math.pow(P_mean-Q_mean,2)/(P_variance1+Q_variance1));
        System.out.println(bhatta);
        return bhatta;
    }
}
