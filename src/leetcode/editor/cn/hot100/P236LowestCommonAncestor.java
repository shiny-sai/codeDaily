package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.treenode.TreeNode;
import leetcode.editor.cn.hot100.treenode.TreeNodeUtil;

/**
 * Author: 曹赛
 * Date: 2025/1/11
 * Description:给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class P236LowestCommonAncestor {

    public static void main(String[] args) {

    }

    /**
     * 递归+拆分成子问题，寻找最近的公共祖先
     * @param root 根结点
     * @param p 寻找的节点p
     * @param q 寻找的节点q
     * @return 最近的公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 递归终止条件
        if (root == null || root == p || root == q) {
            return root;
        }

        // 分别递归左右子树，查看左右子树中是否包含p 、 q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 若左右子树分别包含 p，q，那当前节点就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }

        // 返回包含p、q的根结点 或者 都不包含时返回null
        return (left == null) ? right : left;
    }
}
