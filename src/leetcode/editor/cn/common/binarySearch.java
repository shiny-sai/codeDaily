package leetcode.editor.cn.common;

/**
 * Author: caosai
 * Title: 二分查找
 * Date: 2024/11/3
 */
public class binarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3 ,4, 5, 6};
        binarySearch bs = new binarySearch();
        int result = bs.search1(nums, 1);
        System.out.println("result:"+result);
    }

    /**
     * 二分查找-区间左闭右开
     * @param nums 数组
     * @param target 查找的目标元素
     * @return 查找的元素下标，未找到返回-1
     */
    public int search(int[] nums, int target) {

        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }


    /**
     * 二分查找-区间左闭右闭
     * @param nums 数组
     * @param target 查找的元素目标
     * @return 查找到的元素下标
     */
    public int search1(int[] nums, int target) {

        // 避免查找的target不在数组中而陷入多次循环
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
