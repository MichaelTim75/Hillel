package edu.hillel.lesson8;

public class ArrayValueCalculator {
    final static private int ARRAY_DIMENSION_THRESHOLD=4;

    //first method throws ArraySizeException,ArrayDataException.
    // But I try to add reaction on another global exception - and now method throws global Exception because my exceptions extends of Exception
    public int doCalc(String[][] arr) throws Exception {
        if (arr.length>ARRAY_DIMENSION_THRESHOLD){
            throw new ArraySizeException("Dimension of array "+arr.length+" is over limit="+ARRAY_DIMENSION_THRESHOLD);
        } else if (arr.length==0) {
            throw new Exception("Input array is empty!!");

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
                    throw new ArrayDataException("Data in row "+i+" and column "+j+" is \""+arr[i][j]+"\" and cannot be parsed to int!",e);
                }
            }
        }
        if (arr[1][1].equals("0")){
            totalSum=totalSum/Integer.parseInt(arr[1][1]);
        }
        return totalSum;
    }
}
