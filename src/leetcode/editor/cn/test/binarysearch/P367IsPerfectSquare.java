package leetcode.editor.cn.test.binarysearch;

public class P367IsPerfectSquare {

    // Test
    public static void main(String[] args) {

        P367IsPerfectSquare ips = new P367IsPerfectSquare();
        boolean res = ips.isPerfectSquare(625);
        System.out.println(res);
    }

    /**
     * 返回某个数是不是有效的完全平方数
     * @param num 给定数
     * @return true/false
     */
    public boolean isPerfectSquare(int num) {

        int low = 1, high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid == num) {
                return true;
            } else if ((long) mid * mid < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
