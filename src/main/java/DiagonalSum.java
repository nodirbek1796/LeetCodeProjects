public class DiagonalSum {
    public static void main(String[] args) {

    }

    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int j = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            mat[i][i] = 0;
            sum += mat[i][j];
            j--;
        }
        return sum;
    }
}
