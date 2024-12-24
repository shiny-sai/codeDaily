package leetcode.editor.cn.test.binarysearch;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 */
public class P154FindMin {

    public static void main(String[] args) {
        P154FindMin fm = new P154FindMin();
        int[] nums = new int[]{1,3,5};
        int res = fm.findMin(nums);
        System.out.println(res);
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // mid 右侧均小于右边界
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // mid 左侧均大于右边界
                right = mid;
            } else {
                // 存在重复元素 相等时 无法判断最小值是否在中间，直接右边界缩小
                right--;
            }
        }
        return nums[right];
    }
}
