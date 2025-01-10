package leetcode.editor.cn.hot100.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* Author: 曹赛
* Date: 2025/1/10
*/
public class TreeNodeUtil {


    /**
     * 从数组构造二叉树的方法
     * @param arr 数组
     * @return 二叉树
     */
    public TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < arr.length) {
            TreeNode curr = queue.poll();

            // 构造左子节点
            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                queue.offer(curr.left);
            }
            i++;

            // 构造右子节点
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    /**
     * 打印二叉树（层序遍历）
     * @param root 根节点
     */
    public void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<String>> levels = new ArrayList<>(); // 存储每一层的节点值

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    level.add("null");
                }
            }

            levels.add(level);
        }

        // 移除最后几层完全为 null 的层
        while (!levels.isEmpty() && levels.get(levels.size() - 1).stream().allMatch(e -> e.equals("null"))) {
            levels.remove(levels.size() - 1);
        }

        // 打印结果
        for (List<String> level : levels) {
            System.out.println(level);
        }
    }
}
