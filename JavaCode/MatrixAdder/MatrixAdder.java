//(9/24/2025)
/*
 * Brody Thomas
 */
//I had help from a tutor
//Now Using Fancy 2D Arrays!!!

import java.util.Scanner;

public class MatrixAdder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Welcome to the matrix adder program!");

        //Should get the size of the first matrix
        System.out.println("Please enter the length and width of the first matrix");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();

        //Should create and fill the first matrix
        int[][] matrix1 = new int[rows1][cols1];
        fillMatrix(scanner, matrix1, "first");

        //Should get the size of the second matrix
        System.out.println("Please enter the length and width of the second matrix");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();

        //Should create and fill the second matrix
        int[][] matrix2 = new int[rows2][cols2];
        fillMatrix(scanner, matrix2, "second");

        //Should check if the sizes match
        if(rows1 != rows2 || cols1 != cols2) {
           System.out.println("Invalid Dimensions. These cannot be added.");
           scanner.close();
           return;
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //A D D  M A T R I C E S
        int[][] result = addMatrices(matrix1, matrix2);

        //Should print the matrices and results
        printMatrix(matrix1);
        System.out.println("+");
        printMatrix(matrix2);
        System.out.println("=");
        printMatrix(result);

        scanner.close();
    }

    //Should fill a matrix with users numbers
    private static void fillMatrix(Scanner scanner, int[][] matrix, String name) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.printf("Enter value at index %d %d\n", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    //Should add two matrices and return the result
    private static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] sum = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Should make the matrix
    private static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for(int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}