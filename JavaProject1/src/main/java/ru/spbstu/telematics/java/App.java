package ru.spbstu.telematics.java;

public class App 
{
    public static void main(String[] args)
    {}

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2)
    {
	    final int length = matrix1.length;
		int[][] matrixResult = new int[length][length];
		
	    for (int row = 0; row < length; row++) {
	       	for (int column = 0; column < length; column++) {
	       		for (int elem = 0; elem < length; elem++) {
	       			matrixResult[row][column] += matrix1[row][elem] * matrix2[elem][column];      			        			        		        	         
        		}
			}
	    }

	    return matrixResult;
	}
}
