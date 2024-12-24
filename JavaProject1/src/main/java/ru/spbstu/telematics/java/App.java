package ru.spbstu.telematics.java;

public class App 
{
    public static void main(String[] args)
    {}

    /**
     * Метод для перемножения двух матриц.
     *
     * @param matrix1 Первая матрица (m x n)
     * @param matrix2 Вторая матрица (p x q)
     * @return Результирующая матрица (m x q)
     * @throws IllegalArgumentException если матрицы имеют несовместимые размерности или некорректную структуру
     */
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2)
    {
        // Проверка на null
        if (matrix1 == null || matrix2 == null) {
            throw new IllegalArgumentException("Матрицы не должны быть null.");
        }

        // Проверка, что матрицы не пустые
        if (matrix1.length == 0 || matrix2.length == 0) {
            throw new IllegalArgumentException("Матрицы не должны быть пустыми.");
        }

        // Количество строк и столбцов в первой матрице
        int m1Rows = matrix1.length;
        int m1Cols = matrix1[0].length;

        // Проверка, что все строки первой матрицы имеют одинаковую длину
        for (int i = 1; i < m1Rows; i++) {
            if (matrix1[i].length != m1Cols) {
                throw new IllegalArgumentException("Первая матрица имеет неравномерные строки.");
            }
        }

        // Количество строк и столбцов во второй матрице
        int m2Rows = matrix2.length;
        int m2Cols = matrix2[0].length;

        // Проверка, что все строки второй матрицы имеют одинаковую длину
        for (int i = 1; i < m2Rows; i++) {
            if (matrix2[i].length != m2Cols) {
                throw new IllegalArgumentException("Вторая матрица имеет неравномерные строки.");
            }
        }

        // Проверка совместимости размерностей
        if (m1Cols != m2Rows) {
            throw new IllegalArgumentException("Нельзя перемножить матрицы: число столбцов первой матрицы ("
                    + m1Cols + ") не равно числу строк второй матрицы (" + m2Rows + ").");
        }

        // Создание результирующей матрицы размером m1Rows x m2Cols
        int[][] matrixResult = new int[m1Rows][m2Cols];

        for (int row = 0; row < m1Rows; row++) {
            for (int column = 0; column < m2Cols; column++) {
                for (int elem = 0; elem < m1Cols; elem++) {
                    matrixResult[row][column] += matrix1[row][elem] * matrix2[elem][column];
                }
            }
        }

        return matrixResult;
	}

    /**
     * Печать матрицы на консоль
     * @param matrix матрица, которую нужно вывести
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + "\t");
            }
            System.out.println();
        }
    }
}
