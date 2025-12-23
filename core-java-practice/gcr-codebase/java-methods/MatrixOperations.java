import java.util.Random;

// Program to perform basic matrix operations (add, subtract, multiply)
public class MatrixOperations {

    // Generate random matrix with given dimensions
    public static int[][] generateRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10); // Random numbers 0-9
        return matrix;
    }

    // Add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = a[i][j] + b[i][j];
        return result;
    }

    // Subtract two matrices
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = a[i][j] - b[i][j];
        return result;
    }

    // Multiply two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rowsA = a.length, colsA = a[0].length;
        int colsB = b[0].length;
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++)
            for (int j = 0; j < colsB; j++)
                for (int k = 0; k < colsA; k++)
                    result[i][j] += a[i][k] * b[k][j];
        return result;
    }

    // Print matrix in formatted way
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Generate test matrices
        int[][] matrixA = generateRandomMatrix(2, 3);
        int[][] matrixB = generateRandomMatrix(2, 3);
        int[][] matrixC = generateRandomMatrix(3, 2);

        // Display matrices and operations
        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        System.out.println("Matrix A + B:");
        printMatrix(addMatrices(matrixA, matrixB));

        System.out.println("Matrix A - B:");
        printMatrix(subtractMatrices(matrixA, matrixB));

        System.out.println("Matrix A x C:");
        printMatrix(multiplyMatrices(matrixA, matrixC));
    }
}