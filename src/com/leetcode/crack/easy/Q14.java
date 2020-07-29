package com.leetcode.crack.easy;

public class Q14 {
    /*
    编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。

    示例 1:

    输入: ["flower","flow","flight"]
    输出: "fl"
    示例 2:

    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-common-prefix
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        String prefix = new Q14().longestCommonPrefix(new String[]{});
        System.out.println(prefix);
    }

    public String longestCommonPrefix(String[] strs) {
        int length = 1;
        int fitLength = 0;

        if(strs.length <= 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for(String str : strs) {
            if(minLength > str.length()) {
                minLength = str.length();
            }
        }

        if(minLength <= 0) {
            return "";
        }

        boolean getMore = true;
        do {
            String prefix = strs[0].substring(0, length);
            for(String str : strs) {
                if(str.indexOf(prefix) != 0) {
                    getMore = false;
                }
            }
            if(getMore) {
                fitLength++;
                length++;
            }
        } while(getMore && fitLength < minLength);
        return strs[0].substring(0, fitLength);
    }
}
