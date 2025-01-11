package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;
import leetcode.editor.cn.hot100.treenode.TreeNodeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: 曹赛
 * Date: 2025/1/11
 * Description: 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class P437PathSum {

    public static void main(String[] args) {

        TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
        Integer[] nums = new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = treeNodeUtil.buildTree(nums);
        P437PathSum pathSum = new P437PathSum();
        int res = pathSum.pathSum(root, 8);
        System.out.println(res);
    }

    /**
     * 计算路径之和等于targetSum的路径条数
     * @param root 二叉树根结点
     * @param targetSum 目标值
     * @return 路径条目数
     */
    public int pathSum(TreeNode root, int targetSum) {
        // 记录路径和的前缀和出现次数
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L,1);

        return dfs(root, targetSum, 0, prefixSum);
    }

    /**
     * DFS递归遍历计算路径和次数
     * @param root 根结点
     * @param targetSum 目标和
     * @param prefixSum 前缀和哈希表
     * @return 次数
     */
    public int dfs(TreeNode root, int targetSum, long currentSum, Map<Long, Integer> prefixSum) {
        if (root == null) {
            return 0;
        }

        currentSum += root.val;

        // 计算当前节点到根结点的路径和与目标和的差值，并在哈希表中查看差值是否存在
        int result = prefixSum.getOrDefault(currentSum - targetSum, 0);

        // 更新前缀和在哈希表中出现的次数
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0)+1);

        // 递归计算左子树与右子树的路径和
        result += dfs(root.left, targetSum, currentSum, prefixSum);
        result += dfs(root.right, targetSum, currentSum, prefixSum);

        // 由于每次递归，都会更新哈希表和 currentSum , 递归完后最好还原，不然会影响其他节点的计算
        // 回溯时，将当前路径和的出现次数减少1
        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);

        return result;
    }
}
