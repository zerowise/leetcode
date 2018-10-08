package com.github.zerowise.leetcode;

import java.util.Arrays;


public class Solution {

    /**
     * 爱丽丝有一手（hand）由整数数组给定的牌。
     *
     * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
     *
     * 如果她可以完成分组就返回 true，否则返回 false。
     */
    public static boolean isNStraightHand(int[] hand, int w) {
        if (w == 1) {
            return hand.length >= w;
        }
        int firstEleIndex = 0;
        int num = 0;
        while (firstEleIndex + w <= hand.length) {
            int[] tmpArray = new int[w];
            tmpArray[0] = hand[firstEleIndex];
            int tempInHandsIndex = firstEleIndex + 1;
            int tempInTempIndex = 0;
            while (tempInHandsIndex < hand.length) {
                if (hand[tempInHandsIndex] == tmpArray[tempInTempIndex] + 1) {
                    tmpArray[tempInTempIndex + 1] = hand[tempInHandsIndex];
                    tempInTempIndex++;
                    if (tempInTempIndex == w - 1) {
                        num++;
                        if (num >= w) {
                            return true;
                        }
                        break;
                    }
                }
                tempInHandsIndex++;
            }
            firstEleIndex++;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{2, 1}, 2));
    }


    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     *
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}