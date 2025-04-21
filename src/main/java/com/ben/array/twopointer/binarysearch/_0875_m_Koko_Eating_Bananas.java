package com.ben.array.twopointer.binarysearch;

import com.ben.common.PrintUtil;

public class _0875_m_Koko_Eating_Bananas {

    public static void main(String[] args) {
//        int[] piles = new int[]{3, 6, 7, 11};
//        int h = 8;

        int[] piles = new int[]{312884470};
        int h = 968709470;
        PrintUtil.printLn(new Solution().minEatingSpeed(piles, h));
    }

    static
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            //Max
            long left = 1;
            //Sum
            long right = 0;

            for (int pile : piles) {
                right = Math.max(pile, right);
            }

            while (left < right) {
                int mid = (int) ((left + right) / 2);
                if (mid == 0) {
                    return 1;
                }
                int needed = 0;

                for (int pile : piles) {
                    needed += Math.ceil((double) pile / mid);
                }

                if (needed > h) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return (int) left;
        }
    }
}
