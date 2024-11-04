package leetcode.editor.cn.test;

public class P69MySqrt {

    // Test
    public static void main(String[] args) {
        P69MySqrt ms = new P69MySqrt();
        int res = ms.mySqrt(226);
        System.out.println(res);
    }

    /**
     * 返回x的算数平方根
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int low = 0, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid == x) {
                // 用例 x = 2147395599失败 （long）强转下 避免溢出
                return mid;
            } else if ((long) mid * mid < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if ((long) low * low < x) {
            return low;
        }
        return low - 1;
    }

}
