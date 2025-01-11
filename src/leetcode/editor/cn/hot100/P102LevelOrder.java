package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;
import leetcode.editor.cn.hot100.treenode.TreeNodeUtil;

import java.util.*;

/**
 * Author: 曹赛
 * Date: 2025/1/11
 * Description: 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class P102LevelOrder {

    public static void main(String[] args) {

        TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
        Integer[] nums = new Integer[]{};
        TreeNode root = treeNodeUtil.buildTree(nums);
        P102LevelOrder levelOrder = new P102LevelOrder();
        List<List<Integer>> res = levelOrder.levelOrder(root);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * 层序遍历二叉树
     * @param root 根节点
     * @return 返回层序遍历后的List集合
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            levels.add(currentLevel);
        }
        return levels;
    }
}
