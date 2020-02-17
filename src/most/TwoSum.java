package most;

import java.util.ArrayList;

public class TwoSum {
    public ArrayList<Integer> indexsSum(int[] nums, int target){
        int left = 0,right = nums.length-1;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=left,j=right;i<j;){
            if (nums[i]+nums[j]<target){
                i++;
            }else if (nums[i]+nums[j]>target){
                j--;
            }else {
                left=i;
                right=j;
                break;
            }
        }
        result.add(left+1);
        result.add(right+1);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        ArrayList result = new TwoSum().indexsSum(nums, target);
        System.out.println(result);
    }
}
