package com.github.zerowise.leetcode;

import java.util.Arrays;

/**
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 *
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *
 * 如果她可以完成分组就返回 true，否则返回 false。
 */
public class Solution {
    public static boolean isNStraightHand(int[] hand, int w) {
        if (w == 1) {
            return hand.length >= w;
        }
        Arrays.sort(hand);
        int firstEleIndex = 0;
        int num = 0;
        while (firstEleIndex + w < hand.length) {
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
                        Arrays.toString(tmpArray);
                        break;
                    }
                }
                tempInHandsIndex++;
            }
            if (num == w) {
                return true;
            }
            firstEleIndex++;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 1));
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }
}