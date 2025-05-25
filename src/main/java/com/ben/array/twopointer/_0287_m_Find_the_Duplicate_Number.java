package com.ben.array.twopointer;

public class _0287_m_Find_the_Duplicate_Number {
    class Solution {
        public int findDuplicate(int[] nums) {
            //Treat num[n] as the next point of n
            //This problem can transfer to circle list 2,  find the entrance of a circle in the linked list
            int slow = nums[0];
            int fast = nums[0];

            //Need to use do while, otherwise the first condition check will fail

            do {
                slow = nums[slow];

                //nums[nums[fast]] means next.next
                fast = nums[nums[fast]];
            } while (fast != slow);

            slow = nums[0];

            while (fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }
    }
}
