// 2163. Minimum Difference in Sums After Removal of Elements

import java.util.*;

class Solution {
    public long minimumDifference(int[] nums) {

        int totalLength = nums.length; //total length = 3*n
        int n = totalLength / 3;

        //To store sum of n smallest from left
        long[] minLeftSum = new long[totalLength]; 
        //To store sum of n largest from right  
        long[] maxRightSum = new long[totalLength];   

        //Step 1: Calculate minLeftSum using MaxHeap to keep n smallest elements on left side
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long currentLeftSum = 0;

        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            currentLeftSum += nums[i];

            if (maxHeap.size() > n) {
                currentLeftSum -= maxHeap.poll();  //Remove largest to keep n smallest
            }

            minLeftSum[i] = currentLeftSum;
        }

        //Step 2: Calculate maxRightSum using MinHeap to keep n largest elements on right side
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long currentRightSum = 0;

        for (int i = totalLength - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            currentRightSum += nums[i];

            if (minHeap.size() > n) {
                currentRightSum -= minHeap.poll();  //Remove smallest to keep n largest
            }

            maxRightSum[i] = currentRightSum;
        }

        //Step 3: Find minimum difference between left sum and right sum
        long minDifference = Long.MAX_VALUE;

        for (int i = n - 1; i < 2 * n; i++) {
            minDifference = Math.min(minDifference, minLeftSum[i] - maxRightSum[i + 1]);
        }

        return minDifference;
    }
}
