package leetcode.editor.cn.hot100;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列
 */
public class P240SearchMatrix {

    public static void main(String[] args) {
        P240SearchMatrix searchMatrix = new P240SearchMatrix();
        int[][] matrix = new int[][]{{1}};
        boolean res = searchMatrix.searchMatrix(matrix, 1);
        System.out.println(res);
    }

    /**
     * 在特殊排序的二维数组中寻找目标值
     * @param matrix 二维数组
     * @param target 目标值
     * @return 是否存在目标值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i <= m - 1 && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
