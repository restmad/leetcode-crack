package com.leetcode.crack.easy;

import java.util.HashMap;
import java.util.Map;

public class Q20 {
    /*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        boolean result = new Q20().isValid("{[]}");
        System.out.println(result ? "YES":"NO");
    }

    //{[]}, ([)]
    public boolean isValid(String s) {
        boolean result = true;

        Map<Character, Integer> chMap = new HashMap<>();
        chMap.put('{', 1);
        chMap.put('}', 1);
        chMap.put('(', 2);
        chMap.put(')', 2);
        chMap.put('[', 3);
        chMap.put(']', 3);

        char[] tempChs = new char[s.length()];
        int index = 0;

        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if(ch == ')' || ch == '}' || ch == ']') {
                //  find prefix
                if(index > 0) {
                    //  find prefix
                    if(!chMap.get(ch).equals(chMap.get(tempChs[--index]))) {
                        result = false;
                        break;
                    }
                } else {
                    result = false;
                    break;
                }
            } else {
                tempChs[index++] = ch;
            }
        }

        if(index > 0) {
            result = false;
        }

        return result;
    }
}
