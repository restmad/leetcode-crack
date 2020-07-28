package com.leetcode.crack.easy;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Q9 {
    /*
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

    示例 1:

    输入: 121
    输出: true
    示例 2:

    输入: -121
    输出: false
    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    示例 3:

    输入: 10
    输出: false
    解释: 从右向左读, 为 01 。因此它不是一个回文数。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/palindrome-number
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        boolean result = new Q9().isPalindrome(1000021);
        System.out.println(result ? "OK": "Failed");
    }

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int length = 0;
        int num = x;
        while(num > 0) {
            num /= 10;
            length++;
        }
        while(x > 0 && length > 1) {
            //  head
            int head = x;
            length--;
            for(int i = 0; i < length; i++) {
                head /= 10;
            }

            //  foot
            int foot = x % 10;
//            System.out.println("head: " + head + ", foot: " + foot);
            if(head != foot) {
                return false;
            }
            int prefix = head;
            for(int i = 0; i < length; i++) {
                prefix *= 10;
            }
//            System.out.println("x: " + x + ", prefix:" + prefix + ", foot: " + foot);
            x = x - prefix - foot;
            x /= 10;
//            System.out.println("x: " + x);
            length--;
        }
        return true;
    }
}
