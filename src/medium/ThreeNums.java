package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNums {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int left = i+1,right=nums.length-1;left<right;){
                if(nums[i]+nums[left]==-nums[right]){
                    List<Integer> list = new ArrayList<Integer>();
//                    list.add(nums[i]);
//                    list.add(nums[left++]);
//                    list.add(nums[right--]);
//                    resList.add(list);
                    resList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left<right&&nums[left]==nums[left+1]) left++;
                    while (left<right&&nums[right]==nums[right--]) right--;
                    left++;
                    right--;
                }else if(nums[i]+nums[left]>nums[right]){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        List<List<Integer>> result = new ThreeNums().threeSum1(nums);
        System.out.println(result);
    }
}
