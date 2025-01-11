package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: 曹赛
 * Date: 2025/1/11
 * Description:
 */
public class P105BuildTree {

    public static void main(String[] args) {


    }

    /**
     * 根据先序遍历和中序遍历构建二叉树
     * @param preorder 先序遍历数组，其中第一个元素是根节点，接下来是左子树和右子树的元素
     * @param inorder 中序遍历数组，根节点位于左子树和右子树的分界处
     * @return 构造的二叉树的根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, indexMap);
    }

    /**
     *
     * @param preorder 先序遍历数组
     * @param preStart 当前先序遍历区间的起始位置
     * @param preEnd 当前先序遍历区间的结束位置
     * @param inorder 中序遍历数组
     * @param inStart 当前中序遍历区间的起始位置
     * @param inEnd 当前中序遍历区间的结束位置
     * @param indexMap  一个哈希表，用来存储中序遍历数组中每个元素的索引位置，以便快速查找根节点位置
     * @return 当前递归构造的二叉树根节点
     */
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        // 递归终止条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 首先根据先序遍历构造根节点
        TreeNode root = new TreeNode(preorder[preStart]);

        // 再在中序遍历数组中找出根节点索引 得出左子树 和 右子树区间
        int index = indexMap.get(preorder[preStart]);

        // 计算左子树的节点数
        int leftSize = index - inStart;

        // 构建左子树
        root.left = build(preorder, preStart+1, preStart+leftSize, inorder, inStart, index-1, indexMap);
        // 构建右子树
        root.right = build(preorder, preStart+leftSize+1, preEnd, inorder, index+1, inEnd, indexMap);
        return root;
    }

}
