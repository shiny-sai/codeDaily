package leetcode.editor.cn.test.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 *
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 *
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 */
public class P904TotalFruit {

    // Test
    public static void main(String[] args) {
        P904TotalFruit tf = new P904TotalFruit();
        int[] fruits = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        int res = tf.totalFruit(fruits);
        System.out.println(res);
    }

    /**
     * 计算最大水果数量 [1,2,1]
     * @param fruits 水果种类数组，数组值为每棵树的水果种类（理解为编号）
     * @return 最多摘几棵树/篮子里最多拿多少水果
     */
    public int totalFruit(int[] fruits) {
        int slowIndex = 0;
        int maxLength = 0;
        Map<Integer, Integer> type = new HashMap<>();
        for (int fastIndex = 0; fastIndex < fruits.length; fastIndex++) {
            type.put(fruits[fastIndex], type.getOrDefault(fruits[fastIndex], 0)+1);
            while (type.size() > 2) {
                type.put(fruits[slowIndex], type.get(fruits[slowIndex]) - 1);
                // 如果某种类型水果数量为0了，应该从哈希表中去除掉
                if (type.get(fruits[slowIndex]) == 0) {
                    type.remove(fruits[slowIndex]);
                }
                slowIndex++;
            }
            // 这里求最大数量应该放到最后，不然可能长度计算会多1
            maxLength = Math.max(maxLength, fastIndex - slowIndex + 1);
        }
        return maxLength;
    }
}
