package com.leetcode.crack.easy;

/*
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q28 {
    public static void main(String[] args) {
        int num1 = new Q28().strStr("aaaaa", "bba");
        System.out.println(num1);
        int num2 = new Q28().strStr("hello", "ll");
        System.out.println(num2);
    }

    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }

        char[] firstChs = haystack.toCharArray();
        char[] secondChs = needle.toCharArray();
        for(int i = 0; i < firstChs.length; i++) {
            int count = 0;
            //  第二个数组匹配
            for(int j = 0; j < secondChs.length && i + j < firstChs.length; j++) {
                if(firstChs[i+j] != secondChs[j]) {
                    //  匹配失败，继续
                    break;
                } else {
                    count++;
                }
            }
            if(count == secondChs.length) {
                //  匹配成功
                return i;
            }
        }
        return -1;
    }
}
