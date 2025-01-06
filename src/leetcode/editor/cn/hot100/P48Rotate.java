package leetcode.editor.cn.hot100;

import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class P48Rotate {

    public static void main(String[] args) {
        P48Rotate rotate = new P48Rotate();
        int[][] matrix = new int[][]{{1}};
        rotate.rotate(matrix);
        for (int[] res : matrix) {
            System.out.println(Arrays.toString(res));
        }
    }

    /**
     * 旋转二维数组 先上下对称反转 再主对角线对称反转
     * @param matrix 二维数组
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int top = 0, bottom = n-1;

        // 先上下对称反转二维数组
        while (top < bottom) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = temp;
            }
            top++;
            bottom--;
        }

        // 再以主对角线对称反转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
