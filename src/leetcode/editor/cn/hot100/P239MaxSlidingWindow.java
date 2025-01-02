package leetcode.editor.cn.hot100;

import java.util.*;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 */
public class P239MaxSlidingWindow {

    public static void main(String[] args) {
        P239MaxSlidingWindow msw = new P239MaxSlidingWindow();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = msw.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 返回滑动窗口最大值（双端队列）
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if (n * k == 0) return new int[]{0};    // 若n=0或k=0
        int[] result = new int[n - k + 1];

        // 双端队列 存储滑动窗口内的最大值到最小值排序的索引
        Deque<Integer> deque = new LinkedList<>();
        // 此队列存放的是索引！！例如nums=[2,4,3,1] k = 2,则 deque=[1,2,0,3]

        for (int right = 0; right < n; right++) {
            // 如果最大值索引（deque的第一个值）不在滑动窗口包含的索引范围内，则说明当前滑动窗口的最大值要更新
            if (!deque.isEmpty() && deque.peekFirst() < right - k + 1) {
                deque.pollFirst();  // 弹出头部第一个元素；peekFirst()为获取头部第一个元素 并不弹出
            }

            // 如果滑动窗口内出现了比最小值更大的元素，那比nums[right]小的元素 都要剔除，因为双端队列存储的索引对应的元素是由大到小排列的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            // 清理干净后 再将right存入队列
            deque.offerLast(right);

            if (right >= k - 1) {
                // 为什么是k-1 因为当right = k-1时，0---k-1刚好为第一个长度为k的滑动窗口，后续每次移动right都是长度为k的滑动窗口在移动
                result[right - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
