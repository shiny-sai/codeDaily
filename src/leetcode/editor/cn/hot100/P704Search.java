package leetcode.editor.cn.hot100;

/**
 * Author: 曹赛
 * Date: 2025/3/17
 * Description:给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class P704Search {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        P704Search search = new P704Search();
        int res = search.search(nums, 3);
        System.out.println(res);
    }

    /**
     * 二分查找
     * @param nums 数组（有序升序）
     * @param target 目标值
     * @return 返回目标值下标
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
