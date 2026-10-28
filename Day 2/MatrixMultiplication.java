public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] first = {{1, 2}, {3, 4}};
        int[][] second = {{5, 6}, {7, 8}};
        int[][] product = new int[2][2];

        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 2; column++) {
                for (int number = 0; number < 2; number++) {
                    product[row][column] += first[row][number] * second[number][column];
                }
            }
        }

        System.out.println("Matrix product:");
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 2; column++) {
                System.out.print(product[row][column] + " ");
            }
            System.out.println();
        }
    }
}
