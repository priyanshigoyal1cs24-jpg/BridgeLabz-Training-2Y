class java15{
    public static int[][] transpose(int[][] M) {
        int[][] T = new int[M[0].length][M.length];
        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M[0].length; j++)
                T[j][i] = M[i][j];
        return T;
    }

    public static int determinant2x2(int[][] M) {
        return M[0][0]*M[1][1] - M[0][1]*M[1][0];
    }

    public static int determinant3x3(int[][] M) {
        return M[0][0]*(M[1][1]*M[2][2]-M[1][2]*M[2][1]) -
               M[0][1]*(M[1][0]*M[2][2]-M[1][2]*M[2][0]) +
               M[0][2]*(M[1][0]*M[2][1]-M[1][1]*M[2][0]);
    }

    public static double[][] inverse2x2(int[][] M) {
        double det = determinant2x2(M);
        if (det == 0) return null;
        double[][] inv = {
            { M[1][1]/det, -M[0][1]/det },
            { -M[1][0]/det, M[0][0]/det }
        };
        return inv;
    }

    public static void printMatrix(double[][] M) {
        for (double[] row : M) {
            for (double val : row) System.out.printf("%.2f ", val);
            System.out.println();
        }
    }

    public static void printMatrix(int[][] M) {
        for (int[] row : M) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] M2 = {{4,7},{2,6}};
        System.out.println("Matrix:");
        printMatrix(M2);
        System.out.println("Determinant = " + determinant2x2(M2));
        System.out.println("Inverse:");
        printMatrix(inverse2x2(M2));

        int[][] M3 = {{6,1,1},{4,-2,5},{2,8,7}};
        System.out.println("\n3x3 Matrix:");
        printMatrix(M3);
        System.out.println("Determinant = " + determinant3x3(M3));
        System.out.println("Transpose:");
        printMatrix(transpose(M3));
    }
}
