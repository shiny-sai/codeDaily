package newcoder;

import java.util.Scanner;

/**
 * Author: 曹赛
 * Date: 2025/2/20
 * Description:
 */
public class P3LongestSubsequenceWithSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] strs = in.nextLine().split(",");
            int target = Integer.parseInt(in.nextLine());
            int i = 0;
            int[] nums = new int[strs.length];
            for (String str : strs) {
                nums[i++] = Integer.parseInt(str);
            }
            System.out.println(longestSubsequenceWithSum(nums, target));
        }
    }

    public static int longestSubsequenceWithSum(int[] nums, int targetSum) {
        int maxLength = -1;
        int sum = 0;
        for (int start = 0, end = 0; end < nums.length;) {
            sum += nums[end++];
            if (sum < targetSum) {
                continue;
            }
            if (sum == targetSum){
                maxLength = Math.max(maxLength, end - start);
            }
            while (sum > targetSum) {
                sum -= nums[start];
                start++;
            }
        }
        return maxLength;
    }
}
