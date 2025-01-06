package leetcode.editor.cn.hot100;

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class P73SetZeroes {

    public static void main(String[] args) {

        P73SetZeroes setZeroes = new P73SetZeroes();
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes.setZeroes(matrix);
        for (int[] res : matrix) {
            System.out.println(Arrays.toString(res));
        }
    }

    /**
     * 将为0的元素对应的行和列置为0
     * @param matrix 二维数组
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean colZero = false, rowZero = false;

        // 首先查看首行或者首列是否有非零元素
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                rowZero = true;
                break;
            }
        }

        // 再遍历非首行首列 将matrix[i][j] == 0的，对应 首行首列元素标记为0，matrix[0][j] = matrix[i][0] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 对于非首行非首列进行遍历，将值为0的对应的首行和首列对应元素标记为0
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        // 再次遍历首行首列 除去 [0][0]元素，将已经标记的行和列标记为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 再根据标记确定首行首列是否标记为0
        if (colZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (rowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
