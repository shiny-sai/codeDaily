package leetcode.editor.cn.test.binarysearch;

/**
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 */
public class P62FindPeakElement {

    public static void main(String[] args) {
        // TEST
        int[] nums = new int[]{-2147483648};
        P62FindPeakElement fpe = new P62FindPeakElement();
        int res = fpe.findPeakElement(nums);
        System.out.println(res);
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                // mid 比右边小，非最大
                l = mid + 1;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                // mid比左边小，非最大
                r = mid - 1;
            } else {
                // 其余情况 就是mid 比左右都大
                return mid;
            }
        }
        return -1;
    }

}
