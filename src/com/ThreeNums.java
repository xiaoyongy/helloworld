package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//public class ThreeNums {
//    private boolean isThree(int[] nums){
//        boolean flash = false;
//        Arrays.sort(nums);
//        if (nums.length<3||nums[nums.length-1]==0){
//            return false;
//        }
//        do {
//            for(int i = 0;i<nums.length;i++){
//                List<List<Integer>> list = new LinkedList<>();
//            }
//        }
//        return flash;
//    }
//}

public class ThreeNums {
    private static List<List<Integer>> threeSum(int[] num){
        Arrays.sort(num);
        List<List<Integer>> list = new LinkedList<>();

        for(int i=0; i<num.length; i++){
            if(i==0 || (i>0 && num[i] != num[i-1])){
                int sum = 0 - num[i];
                int l = i + 1;
                int h = num.length-1;

                while(l < h){
                    if(num[l]+num[h] == sum){
                        list.add(Arrays.asList(num[i],num[l],num[h]));
                        while((l < h) && (num[l]==num[l+1])) l++;
                        while((l < h) && (num[l]==num[h-1])) h--;
                        l++;
                        h--;
                    }else if(num[l] + num[h] < sum){
                        l++;
                    }else{
                        h--;
                    }
                }
            }
        }
        return list;
    }



    public static void main(String[] args) {
        int[] num = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum(num);
        System.out.println(list.toString());
    }
}
