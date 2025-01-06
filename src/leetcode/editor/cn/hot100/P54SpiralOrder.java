package leetcode.editor.cn.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class P54SpiralOrder {
    public static void main(String[] args) {
        P54SpiralOrder spiralOrder = new P54SpiralOrder();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res = spiralOrder.spiralOrder(matrix);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     *
     * @param matrix 二维数组
     * @return 螺旋读取的List
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        List<Integer> res = new ArrayList<>();
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) { // 检查下边界是否仍然有效
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
