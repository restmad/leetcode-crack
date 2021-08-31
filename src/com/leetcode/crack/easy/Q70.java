package com.leetcode.crack.easy;

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

4
[1,2]
    [1,2]
        [1,2]
            [1,2]
1111
121
211
22
112
每一次爬1-2，剩余数量消耗为0


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q70 {

    public static void main(String[] args) {
        int num = 45;
        System.out.println(new Q70().climbStairs(num));
    }

    java.util.Map<Integer, Integer> resultMap = new java.util.HashMap<>();

    public int climbStairs(int n) {
        //  最简单的递归调用
        if(n == 1) {
            //  剩余1个台阶，1次爬完
            return 1;
        } else if(n == 2) {
            //  剩余2个台阶，可以1次爬完，或者分别1阶爬完，返回2
            return 2;
        } else {
            //  n-1的下一次计算可能是n-2，所以缓存下计算结果
            int num1 = 0;
            Integer key1 = n - 1;
            Integer key2 = n - 2;
            if(resultMap.containsKey(n - 1)) {
                num1 = resultMap.get(key1);
            } else {
                num1 = climbStairs(n - 1);
                resultMap.put(key1, num1);
            }
            int num2 = 0;
            if(resultMap.containsKey(key2)) {
                num2 = resultMap.get(key2);
            } else {
                num2 = climbStairs(n - 2);
                resultMap.put(key2, num2);
            }
            return num1 + num2;
        }

    }
}
