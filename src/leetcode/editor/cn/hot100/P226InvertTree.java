package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;
import leetcode.editor.cn.hot100.treenode.TreeNodeUtil;

/**
 * Author: 曹赛
 * Date: 2025/1/10
 * Description: 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class P226InvertTree {

    public static void main(String[] args) {
        TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
        Integer[] nums = new Integer[]{1,2,2,3,4,4,3};
        TreeNode root = treeNodeUtil.buildTree(nums);
        P226InvertTree invertTree = new P226InvertTree();
        TreeNode res = invertTree.invertTree(root);
        treeNodeUtil.printTree(res);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode node1 = invertTree(root.left);
        TreeNode node2 = invertTree(root.right);
        root.left = node2;
        root.right = node1;
        return root;
    }
}
