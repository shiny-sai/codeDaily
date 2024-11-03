package leetcode.editor.cn.test;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class P35SearchInsert {

    // Test
    public static void main(String[] args) {
        P35SearchInsert si = new P35SearchInsert();
        int[] nums = {1,3,5,6};
        int target = 7;
        int res = si.searchInsert(nums, target);
        System.out.println(res);
    }

    /**
     * 搜索插入位置
     * @param nums 排序数组
     * @param target 目标值
     * @return 目标值索引/被插入位置索引
     */
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (nums[low] < target) {
            return low + 1;
        } else {
            return low;
        }
    }

}
