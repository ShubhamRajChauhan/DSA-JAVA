//leetcode -  1

public class twoSum {
    public  static int[]  sum(int nums[], int target) {
        int arr[] = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j= i+1; j<nums.length; j++){
                int add = nums[i] + nums[j];
                if(i != j && target == add) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        //twoSum ts = new twoSum(); // Create an instance of the twoSum class
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int arr[] = sum(nums, target); // Call the sum method using the instance
        //sum(nums,target);
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
        } else {
            System.out.println("No solution found");
        }

        
        
    }
}
