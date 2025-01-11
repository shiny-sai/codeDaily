package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;
import leetcode.editor.cn.hot100.treenode.TreeNodeUtil;

import java.util.*;

/**
 * Author: 曹赛
 * Date: 2025/1/11
 * Description: 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class P199RightSideView {

    public static void main(String[] args) {
        TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
        Integer[] nums = new Integer[]{1,null,3};
        TreeNode root = treeNodeUtil.buildTree(nums);
        P199RightSideView rightSideView = new P199RightSideView();
        List<Integer> res = rightSideView.rightSideView(root);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * 返回二叉树右视图
     * @param root 二叉树根节点
     * @return 右视图的节点
     */
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rightSideView = new ArrayList<>();
        if (root == null) {
            return rightSideView;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 记录每层的最后一个节点
                if (i == size - 1) {
                    rightSideView.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return rightSideView;
    }
}
