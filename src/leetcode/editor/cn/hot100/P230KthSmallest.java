package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;
import leetcode.editor.cn.hot100.treenode.TreeNodeUtil;

/**
 * Author: 曹赛
 * Date: 2025/1/11
 * Description: 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）
 */
public class P230KthSmallest {

    public static void main(String[] args) {
        TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
        Integer[] nums = new Integer[]{3,1,4,null,2};
        TreeNode root = treeNodeUtil.buildTree(nums);
        P230KthSmallest kthSmallest = new P230KthSmallest();
        int res = kthSmallest.kthSmallest(root, 1);
        System.out.println(res);
    }

    /**
     * 返回二叉树中第k小的元素
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        int[] result = new int[1];
        inOrder(root, k, count, result);
        return result[0];
    }

    /**
     * 中序遍历+递归寻找二叉树第k小的数
     * @param node 二叉树当前节点
     * @param k 第k小
     * @param count 计数器（用数组是因为引用传递，若使用int并不能改变根本值）
     * @param result 存放结果（用数组是因为引用传递，若使用int并不能改变根本值）
     */
    public void inOrder(TreeNode node, int k, int[] count, int[] result) {
        if (node == null) {
            return;
        }

        // 遍历左子树
        inOrder(node.left, k, count, result);

        count[0]++; // 修改 count 的内容
        if (count[0] == k) {
            result[0] = node.val;
            return;
        }
        // 遍历右子树
        inOrder(node.right, k, count, result);
    }
}
