package leetcode.editor.cn.test.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 */
public class P658FindClosestElements {

    public static void main(String[] args) {

        P658FindClosestElements fce = new P658FindClosestElements();
        int[] arr = new int[]{1,2,3,4,5};
        int k = 4;
        int x = 3;
        List<Integer> list = fce.findClosestElements(arr, k, x);
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 返回与x最接近的k个数
     * @param arr 有序数组
     * @param k k个数
     * @param x 目标值
     * @return k个数的列表
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int right = findIndex(arr, x);
        int left = right - 1;
        // 先选出k个数的左右边界范围，left和right
        while (k-- > 0) {
            if (left < 0) {
                // 如果没有比x小的数
                right++;
            } else if (right >= arr.length) {
                // 如果没有比x大的数
                left--;
            } else if (x - arr[left] > arr[right] - x) {
                right++;
            } else {
                left--;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * 返回分界的下标，下标左边均小于x，右边均大于等于x
     * @param arr 有序数组
     * @param x 查找的目标值
     * @return 大于等于x的最小的数的下标
     */
    public int findIndex(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
