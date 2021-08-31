package com.leetcode.crack.easy;

/*
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

 

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
 

提示：

每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q67 {
    public static void main(String[] args) {
        String a = "0", b = "0";
        String s = new Q67().addBinary(a, b);
        System.out.println(s);
    }

    public String addBinary(String a, String b) {

        char[] array1 = a.toCharArray();
        char[] array2 = b.toCharArray();

        int length1 = array1.length;
        int length2 = array2.length;

        int loopLength = 0;
        if(length1 >= length2) {
            loopLength = length1;
        } else {
            loopLength = length2;
        }

        char[] result = new char[loopLength + 1];
        result[0] = '0';
        boolean shouldAdd = false;

        for(int i = 0; i < loopLength; i++) {
            int resultIndex = result.length - 1 - i;
            //  get last i num from array
            char first = '0';
            char second = '0';
            int firstIndex = array1.length - 1 - i;
            if(firstIndex >= 0) {
                first = array1[firstIndex];
            }
            int secondIndex = array2.length - 1 - i;
            if(secondIndex >= 0) {
                second = array2[secondIndex];
            }
            char cal = '0';
            if(shouldAdd) {
                if(first == '1' && second == '1') {
                    shouldAdd = true;
                    cal = '1';
                } else if(first == '1' || second == '1') {
                    shouldAdd = true;
                    cal = '0';
                } else {
                    cal = '1';
                    shouldAdd = false;
                }
            } else {
                if(first == '1' && second == '1') {
                    shouldAdd = true;
                    cal = '0';
                } else if(first == '1' || second == '1') {
                    shouldAdd = false;
                    cal = '1';
                } else {
                    cal = '0';
                    shouldAdd = false;
                }
            }
            result[resultIndex] = cal;
        }
        if(shouldAdd) {
            result[0] = '1';
        }
        if(result[0] == '0') {
            return new String(result, 1, result.length - 1);
        }
        return new String(result);
    }
}
