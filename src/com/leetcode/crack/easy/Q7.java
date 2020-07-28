package com.leetcode.crack.easy;

public class Q7 {
    /*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
        int reverse = new Q7().reverse(1534236469);
        System.out.println(reverse);
        System.out.println(new Q7().reverse(123));
        System.out.println(new Q7().reverse(-123));
//        System.out.println((Integer.MAX_VALUE + 1));
//        System.out.println((964632435 * 10) + 1);
//        System.out.println(1056389759 - 964632435);
    }

    public int reverse(int x) {
        int result = 0;
        boolean isAbove = false;
        if(x > 0) {
            isAbove = true;
        } else {
            x *= -1;
        }


        //  寻找上限的前缀值和后缀值
        int prefix = 0;
        int subfix = 0;
        if(isAbove) {
            prefix = Integer.MAX_VALUE / 10;
            subfix = Integer.MAX_VALUE % 10;
        } else {
            prefix = Integer.MIN_VALUE / 10 * -1;
            subfix = Integer.MIN_VALUE % 10 * -1;
        }

        for(int i = 0; i < 32 && x != 0; i++) {
            int num = x % 10;
            if(num >= 0) {
                //  prefix: result
                //  subfix: num
                if(prefix > result) {
                    result = result * 10 + num;
                } else if(prefix == result) {
                    if(subfix > num) {
                        result = result * 10 + num;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
            x = x / 10;
        }
        if(!isAbove) {
            result *= -1;
        }
        return result;
    }
}
