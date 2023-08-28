package edu.hillel.Lesson8;

import java.util.ArrayList;

public class ArrayValueCalculator {
    final static private int ARRAY_DIMENSION_THRESHOLD=4;

    public int doCalc(String[][] arr) throws ArraySizeException, ArrayDataException {
        if (arr.length>ARRAY_DIMENSION_THRESHOLD){
            throw new ArraySizeException("Dimension of array "+arr.length+" is over limit="+ARRAY_DIMENSION_THRESHOLD);
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i].length>ARRAY_DIMENSION_THRESHOLD){
                throw new ArraySizeException("Dimension of line "+i+" in array "+arr[i].length+" is over limit="+ARRAY_DIMENSION_THRESHOLD);
            }
        }
        int totalSum=0;
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                try{
                    totalSum+=Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e){
                    throw new ArrayDataException("Data in row "+i+" and column "+j+" is \""+arr[i][j]+"\" and cannot be parsed to int!");
                }
            }
        }
        return totalSum;
    }
}
