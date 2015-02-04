/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpfuzzy.test;

import gnpfuzzy.arrayfunction;
import static gnpfuzzy.arrayfunction.bachsort2;
import gnpfuzzy.fuzzy;
import static gnpfuzzy.fuzzy.setbatch;
import gnpfuzzy.fuzzyset;
import gnpfuzzy.fuzzyterm;
import gnpfuzzy.fuzzyvar;

/**
 *
 * @author wirarama
 */
public class test2 {
    public static void test2(){
        fuzzyterm strong = new fuzzyterm();
        strong.name = "strong";
        strong.type = "gaussprod";
        double[] value1 = {80,20,80,5};
        strong.value = value1;
        
        fuzzyterm normal = new fuzzyterm();
        normal.name = "normal";
        normal.type = "gaussprod";
        double[] value2 = {60,10,60,15};
        normal.value = value2;
        
        fuzzyterm weak = new fuzzyterm();
        weak.name = "weak";
        weak.type = "gaussprod";
        double[] value3 = {20,12,20,20};
        weak.value = value3;
        
        fuzzyvar power = new fuzzyvar();
        power.name = "power";
        fuzzyterm[] terms1 = {strong,normal,weak};
        power.terms = terms1;
        
        fuzzy.variablebach(arrayfunction.bachsort(1,100),power);
        
        fuzzyterm expensive = new fuzzyterm();
        expensive.name = "expensive";
        expensive.type = "gaussprod";
        double[] value21 = {600,80,600,250};
        expensive.value = value21;
        
        fuzzyterm average = new fuzzyterm();
        average.name = "average";
        average.type = "gaussprod";
        double[] value22 = {300,80,300,200};
        average.value = value22;
        
        fuzzyterm cheap = new fuzzyterm();
        cheap.name = "cheap";
        cheap.type = "gaussprod";
        double[] value23 = {150,200,150,120};
        cheap.value = value23;
        
        fuzzyvar price = new fuzzyvar();
        price.name = "price";
        fuzzyterm[] terms2 = {expensive,average,cheap};
        price.terms = terms2;
        
        fuzzy.variablebach(arrayfunction.bachsort(100,1000),price);
        
        fuzzyset product = new fuzzyset();
        fuzzyvar[] var = {power,price};
        product.var = var;
        double[][] database = new double[2][1000];
        database[0] = bachsort2(1,100,100);
        database[1] = bachsort2(100,1000,100);
        //setbatch(database,product);
    }
}