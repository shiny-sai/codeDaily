package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;
import leetcode.editor.cn.hot100.treenode.TreeNodeUtil;

/**
 * Author: 曹赛
 * Date: 2025/1/11
 * Description: 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树
 */
public class P108SortedArrayToBST {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        P108SortedArrayToBST sortedArrayToBST = new P108SortedArrayToBST();
        TreeNode res = sortedArrayToBST.sortedArrayToBST(nums);
        TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
        treeNodeUtil.printTree(res);
    }

    /**
     * 根据有序数组构造平衡二叉数
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    /**
     * 递归构造以数组区间中点为根节点的平衡二叉树
     * @param nums 有序数组
     * @param left 有序数组左边界
     * @param right 有序数组右边界
     * @return 二叉树根节点
     */
    public TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums, left, mid - 1);
        root.right = constructBST(nums, mid + 1, right);
        return root;
    }

}
