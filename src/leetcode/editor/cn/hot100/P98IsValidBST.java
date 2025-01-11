package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;
import leetcode.editor.cn.hot100.treenode.TreeNodeUtil;

/**
 * Author: 曹赛
 * Date: 2025/1/11
 * Description: 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树
 */
public class P98IsValidBST {

    public static void main(String[] args) {
        TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
        Integer[] nums = new Integer[]{1,null,3};
        TreeNode root = treeNodeUtil.buildTree(nums);
//        treeNodeUtil.printTree(root);
        P98IsValidBST isValidBST = new P98IsValidBST();
        boolean res = isValidBST.isValidBST(root);
        System.out.println(res);
    }

    /**
     * 判断是否是搜索二叉树
     * @param root 根节点
     * @return true/false
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归验证是否满足二叉搜索树性质
     * @param node 当前节点
     * @param min 当前节点允许的最小值
     * @param max 当前节点允许的最大值
     * @return true/false
     */
    public boolean validate(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        if (node.val >= max || node.val <= min) {
            return false;
        }

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
