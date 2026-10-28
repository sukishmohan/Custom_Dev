public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[][] transpose = new int[3][2];

        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 3; column++) {
                transpose[column][row] = matrix[row][column];
            }
        }

        System.out.println("Transpose:");
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 2; column++) {
                System.out.print(transpose[row][column] + " ");
            }
            System.out.println();
        }
    }
}
