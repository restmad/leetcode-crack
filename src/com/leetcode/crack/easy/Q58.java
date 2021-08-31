package com.leetcode.crack.easy;

/*
给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

 

示例:

输入: "Hello World"
输出: 5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/length-of-last-word
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q58 {
    public static void main(String[] args) {
        int result = new Q58().lengthOfLastWord("Hello World");
        System.out.println(result);
        int result2 = new Q58().lengthOfLastWord("a");
        System.out.println(result2);
    }

    public int lengthOfLastWord(String s) {
        int result = 0;

        if(!s.contains(" ")) {
            return s.length();
        }

        char[] chs = s.toCharArray();
        boolean isStartCount = false;
        for(int i = chs.length - 1; i >= 0; i--) {
            if(chs[i] != ' ') {
                if(!isStartCount) {
                    isStartCount = true;
                }
                result++;
            } else {
                if(isStartCount) {
                    break;
                }
            }
        }

        return result;
    }
}
