package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;

/**
 * Author: 曹赛
 * Date: 2025/1/11
 * Description:给你一棵二叉树的根节点，返回该树的 直径 。二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。两节点之间路径的 长度 由它们之间边数表示。
 */
public class P543DiameterOfBinaryTree {

    public static void main(String[] args) {

    }

    int maxDiameter = 0;    // 记录最长路径长度

    /**
     * 返回二叉树中的最长路径
     * @param root 根节点
     * @return 最长路径长度
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    /**
     * 返回当前节点为根的子树的最大深度，同时更新全局变量 maxDiameter，记录当前的最大路径长度。
     * @param root 根节点
     * @return 以当前节点为根的最大深度
     */
    public int depth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);  // 更新最长路径长度(和边有关 和节点无关

        int maxDepth = Math.max(left, right) + 1;   // 计算最大深度(与节点有关)

        return maxDepth;
    }

}
