package LeetCode;

/**
 * Created by yzwang on 2019/4/3.
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 */
public class Solution_7 {

    public static int reverseInt(int x) {

        int ans = 0;
        while (x != 0) {
            ans = ans * 10 + (x % 10);
            x /= 10;
        }
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            ans = 0;
        }
        return ans;
    }

    public static int reverseInt2(int n){
        int temp = 0;
        int m = 0;

        while(n != 0) {
            m = m * 10 + n % 10;
            if(temp != m/10) {	/*根据补码运算规则,如果发生了 溢出那么temp和m/10的值一定不相等*/
                return 0;
            }
            temp = m;
            n = n/10;
        }

        return m;
    }

    public static void main(String[] args) {
        System.out.println(reverseInt(1234567899));
        System.out.println(reverseInt2(1234567899));
    }
}
