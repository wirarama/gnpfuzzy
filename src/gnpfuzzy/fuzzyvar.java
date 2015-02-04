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
public class fuzzyvar {
    public static String name;
    public static fuzzyterm[] terms;
    
    public static String[] getlabels(){
        String[] out = new String[terms.length];
        for(int i=0;i<terms.length;i++){
            out[i] = terms[i].name;
        }
        return out;
    }
}
