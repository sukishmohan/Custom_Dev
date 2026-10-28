public class MatrixAddition {
    public static void main(String[] args) {
        int[][] first = {{1, 2}, {3, 4}};
        int[][] second = {{5, 6}, {7, 8}};
        int[][] sum = new int[2][2];

        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 2; column++) {
                sum[row][column] = first[row][column] + second[row][column];
            }
        }

        System.out.println("Matrix sum:");
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 2; column++) {
                System.out.print(sum[row][column] + " ");
            }
            System.out.println();
        }
    }
}
