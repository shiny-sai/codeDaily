package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;
import leetcode.editor.cn.hot100.treenode.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: 曹赛
 * Date: 2025/1/10
 * Description: 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class P101IsSymmetric {

    public static void main(String[] args) {
        TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
        Integer[] nums = new Integer[]{1,2,2,3,4,4,3};
        TreeNode root = treeNodeUtil.buildTree(nums);
        P101IsSymmetric isSymmetric = new P101IsSymmetric();
        boolean res = isSymmetric.isSymmetric(root);
        System.out.println(res);
    }

    /**
     * 检查是否对称（迭代）
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        // 如果根节点为空，直接返回 true
        if (root == null) {
            return true;
        }

        return check(root.left, root.right);
    }

    /**
     *检查两个节点是否对称（迭代）
     * @param u 左节点
     * @param v 右节点
     * @return true / false
     */
    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            if (u == null && v ==null) {
                continue;
            }

            if (u == null || v == null || u.val != v.val) {
                return false;
            }

            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);

        }
        return true;
    }

    /**
     * 检查是否对称（递归）
     * @param root 根节点
     * @return true/false
     */
    public boolean isSymmetric1(TreeNode root) {
        // 如果根节点为空，直接返回 true
        if (root == null) {
            return true;
        }

        return check(root, root);
    }

    /**
     * 检查两个节点是否对称（递归）
     * @param left 左节点
     * @param right 右节点
     * @return true / false
     */
    public boolean check1(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null|| right == null) {
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
