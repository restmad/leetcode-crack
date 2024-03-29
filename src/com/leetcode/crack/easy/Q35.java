package com.leetcode.crack.easy;

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-insert-position
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q35 {
    public static void main(String[] args) {
        int num1 = new Q35().searchInsert(new int[]{1, 3, 5, 6}, 0);
        System.out.println(num1);
    }

    public int searchInsert(int[] nums, int target) {
        int insertIndex = -1;
        int equalIndex = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                equalIndex = i;
            } else {
                if(i + 1 < nums.length) {
                    if(nums[i] < target && nums[i + 1] > target) {
                        insertIndex = i + 1;
                    } else if(nums[i] > target) {
                        if(insertIndex == -1) {
                            insertIndex = i;
                        }
                    }
                } else if(i == nums.length - 1) {
                    if(insertIndex == -1) {
                        if (nums[i] < target) {
                            insertIndex = i + 1;
                        } else {
                            insertIndex = i;
                        }
                    }

                }
            }
        }
        if(equalIndex != -1) {
            return equalIndex;
        }
        return insertIndex;
    }
}
