package leetcode.editor.cn.hot100;

import java.util.Scanner;

/**
 * Author: 曹赛
 * Date: 2025/2/19
 * Description:给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false
 */
public class P79WordSearch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 读取 m 和 n
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine(); // 读取换行符

        // 构造字符网格
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            String line = in.nextLine();
            board[i] = line.toCharArray();
        }

        // 读取目标单词
        String word = in.nextLine();

        P79WordSearch wordSearch = new P79WordSearch();

        // 调用回溯算法
        System.out.println(wordSearch.exist(board, word) ? "true" : "false");

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int i, int j, int index) {
        // 终止条件
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // 标记为已经访问
        char temp = board[i][j];
        board[i][j] = '#';

        // 探索四个方向
        boolean found = backtrack(board, word, i+1, j, index+1) ||
                backtrack(board, word, i-1, j, index+1) ||
                backtrack(board, word, i, j+1, index+1) ||
                backtrack(board, word, i, j-1, index+1);
        board[i][j] = temp;
        return found;
    }

}
