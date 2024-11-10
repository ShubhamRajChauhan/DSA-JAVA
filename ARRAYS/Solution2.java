//Search in Rotated Sorted Array

public class Solution2 {
    public static int search(int nums[], int target){
        
        int left = 0;
        int right = nums.length-1;

        while(left <= right)
        {
            int mid=(left+right)/2;
            if(nums[mid] == target)return mid;

            //left sorted
            if(nums[left] <= nums[mid])
            {
                if(nums[left] <= target && target <= nums[mid])
                {
                    right = mid-1;
                }
                else left = mid + 1;
            }
            //right sorted
            else
            {
                if(nums[mid] <= target && target <= nums[right])
                {
                    left = mid+1;
                }
                else right = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {8,9,10,1,2,3,4,5,6,7};
        int target = 10;
        System.out.println("index for key is :" + search(nums, target));
    }
}
