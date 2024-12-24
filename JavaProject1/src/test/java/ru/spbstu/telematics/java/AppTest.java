package ru.spbstu.telematics.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(AppTest.class);
    }


    public void testMultiplyMatrices()
    {
    	int[][] matrix1 = {
    		{1,2,3},
    		{4,5,6},
    		{7,8,9}
    	};

    	int[][] matrix2 = {
    		{3,3,3},
    		{5,1,3},
    		{2,1,2}
    	};

    	int[][] expected = {
			{19,8,15},
			{49,23,39},
			{79,38,63}
    	};

    	int [][] result = App.multiplyMatrices(matrix1, matrix2);

    	for (int i = 0; i < expected.length; i++) {
    		assertTrue(Arrays.equals(expected[i], result[i]));
    	}
    }

    
    public void testIdentityMatrix()
    {
    	int[][] matrix = {
    		{1,2,3},
    		{4,5,6},
    		{7,8,9}
    	};

    	int[][] identity = {
    		{1,0,0},
    		{0,1,0},
    		{0,0,1}
    	};

   
    	int [][] result = App.multiplyMatrices(matrix, identity);

    	for (int i = 0; i < matrix.length; i++) {
    		assertTrue(Arrays.equals(matrix[i], result[i]));
    	}
    }

    
    public void testZeroMatrix()
    {
    	int[][] matrix = {
    		{1,2,3},
    		{4,5,6},
    		{7,8,9}
    	};

    	int[][] identity = {
    		{0,0,0},
    		{0,0,0},
    		{0,0,0}
    	};


    	int [][] result = App.multiplyMatrices(matrix, identity);

    	int[][] expected = {
    		{0,0,0},
    		{0,0,0},
    		{0,0,0}
    	};

    	for (int i = 0; i < expected.length; i++) {
    		assertTrue(Arrays.equals(expected[i], result[i]));
    	}
    }

    public void testRectangularMatrices()
    {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] matrix2 = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        int[][] expected = {
                {58, 64},
                {139, 154}
        };

        int [][] result = App.multiplyMatrices(matrix1, matrix2);

        for (int i = 0; i < expected.length; i++) {
            assertTrue(Arrays.equals(expected[i], result[i]));
        }
    }

	public void testIncompatibleDimensions()
	{
		int[][] matrix1 = {
				{1, 2},
				{3, 4}
		};

		int[][] matrix2 = {
				{5, 6, 7},
				{8, 9, 10},
				{11,12,13}
		};

		try {
			App.multiplyMatrices(matrix1, matrix2);
			fail("Ожидалось исключение IllegalArgumentException при несопоставимых размерах.");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("число столбцов первой матрицы (2) не равно числу строк второй матрицы (3)"));
		}
	}

	public void testRaggedMatrix()
	{
		int[][] matrix1 = {
				{1, 2, 3},
				{4, 5},    // вторая строка короче
				{7, 8, 9}
		};

		int[][] matrix2 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};

		try {
			App.multiplyMatrices(matrix1, matrix2);
			fail("Ожидалось исключение из-за \"рваной\" матрицы.");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("Первая матрица имеет неравномерные строки."));
		}
	}

	public void testNullMatrix()
	{
		int[][] matrix1 = null;
		int[][] matrix2 = {
				{1, 2},
				{3, 4}
		};

		try {
			App.multiplyMatrices(matrix1, matrix2);
			fail("Ожидалось исключение при null-матрице.");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("Матрицы не должны быть null."));
		}
	}
    
}
