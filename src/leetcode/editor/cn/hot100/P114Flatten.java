package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;
import leetcode.editor.cn.hot100.treenode.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;;

/**
 * Author: 曹赛
 * Date: 2025/1/11
 * Description:给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同
 */
public class P114Flatten {

    public static void main(String[] args) {
        TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
        Integer[] nums = new Integer[]{1,2,5,3,4,null,6};
        TreeNode root = treeNodeUtil.buildTree(nums);
        P114Flatten flatten = new P114Flatten();
        flatten.flatten(root);
        treeNodeUtil.printTree(root);
    }

    /**
     * 二叉树展开为一个单链表
     * @param root 根节点
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i-1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    /**
     * 先序遍历
     * @param root 根节点
     * @param list 存放先序遍历结果
     */
    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
