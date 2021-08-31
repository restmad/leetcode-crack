package com.leetcode.crack.easy;

/*
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

 

示例 1：

输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。
示例 2：

输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。
示例 3：

输入：digits = [0]
输出：[1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q66 {
    public static void main(String[] args) {
        int[] digits = new int[]{1,2,3};
        int[] ints = new Q66().plusOne(digits);
        for(int num: ints) {
            System.out.print(num);
        }
    }

    public int[] plusOne(int[] digits) {
        boolean isAdd = true;
        boolean shouldStop = false;
        for(int i = digits.length - 1; i >= 0 && !shouldStop; i--) {
            int num = digits[i];
            if(isAdd) {
                int newNum = num + 1;
                if(newNum == 10) {
                    isAdd = true;
                    newNum = 0;
                } else {
                    isAdd = false;
                    shouldStop = true;
                }
                digits[i] = newNum;
            } else {
                isAdd = false;
                shouldStop = false;
            }
        }
        if(isAdd) {
            int[] nums = new int[digits.length + 1];
            nums[0] = 1;
            for(int i = 0; i < digits.length; i++) {
                nums[i+1] = digits[i];
            }
            return nums;
        }
        return digits;
    }
}
