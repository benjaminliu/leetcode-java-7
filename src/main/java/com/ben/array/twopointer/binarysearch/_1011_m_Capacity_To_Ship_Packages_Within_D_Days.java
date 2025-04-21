package com.ben.array.twopointer.binarysearch;

public class _1011_m_Capacity_To_Ship_Packages_Within_D_Days {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            //Max weight of all the packages
            int left = 0;
            //Sum weight of all the packages
            int right = 0;

            for (int weight : weights) {
                left = Math.max(left, weight);
                right += weight;
            }

            while (left < right) {
                int mid = (left + right) / 2;
                int needed = 1;
                int cur = 0;

                //Calculate how many days needed
                for (int weight : weights) {
                    if (cur + weight > mid) {
                        //need another day
                        needed++;
                        cur = weight;
                    } else {
                        cur += weight;
                    }
                }

                if (needed > days) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
