/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpfuzzy;

import java.io.IOException;

/**
 *
 * @author wirarama
 */
public class GNPfuzzy {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //test2.test2();
        //fuzzysupportcalc.test(8,7);
        kldiv.kldiv(100,100,100,100);
        //hellingerdist.hellingerdist(100,200,20,20);
        hellingerdist.computeHellingerDist(100,10,100,10);
        bhattadist.bhattadist(70,0.1,50,0.4);
    }
}
