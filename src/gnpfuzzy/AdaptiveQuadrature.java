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
public class AdaptiveQuadrature {
    private final static double EPSILON = 1e-1;
    static double f(double x) {
        //return Math.exp(- x * x / 2) / Math.sqrt(2 * Math.PI);
        return fuzzy.gaussprodmf(x, 12, 2, 12, 1);
    }
    // trapezoid rule
    static double trapezoid(double a, double b, int N) {
        double h = (b - a) / N;
        double sum = 0.5 *  h * (f(a) + f(b));
        for (int k = 1; k < N; k++)
            sum = sum + h * f(a + h*k);
        return sum;
    }
    // adaptive quadrature
    public static double adaptive(double a, double b) {
        double h = b - a;
        double c = (a + b) / 2.0;
        double d = (a + c) / 2.0;
        double e = (b + c) / 2.0;
        double Q1 = h/6  * (f(a) + 4*f(c) + f(b));
        double Q2 = h/12 * (f(a) + 4*f(d) + 2*f(c) + 4*f(e) + f(b));
        if (Math.abs(Q2 - Q1) <= EPSILON)
            return Q2 + (Q2 - Q1) / 15;
        else
            return adaptive(a, c) + adaptive(c, b);
    }
}
