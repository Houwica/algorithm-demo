package algorithm.day13;

public class NumericDemo {

    public int[][] construct2DArray(int[] original, int m, int n) {

        int length = original.length;
        if (m * n != length) {
            return new int[][]{};
        }

        int[][] res = new int[m][m];

        int index = 0;
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[index++];
            }
        }

        return res;
    }

    private static int gcb(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcb(b, a % b);

    }

    public static void main(String[] args) {
    }
}
