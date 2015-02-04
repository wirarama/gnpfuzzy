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
public class operation {
    protected static double MACHEPS = 1e-1;
    public static boolean isEq(double a, double b) {
        return Math.abs(a - b) < MACHEPS;
    }
    public static boolean isLt(double a, double b) {
        return !isEq(a, b) && a < b;
    }
    public static boolean isLE(double a, double b) {
        return isEq(a, b) || a < b;
    }
    public static boolean isGt(double a, double b) {
        return !isEq(a, b) && a > b;
    }
    public static boolean isGE(double a, double b) {
        return isEq(a, b) || a > b;
    }
}
