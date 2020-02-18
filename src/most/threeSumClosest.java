package most;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int left=0,middle=0,right=0;
        int targetCloset = Integer.MAX_VALUE,flash=Integer.MAX_VALUE;
        int result=0;
        for(;left<=nums.length-3;left++){
            for(middle=left+1,right=middle+1;middle<right;middle++){
                for(right=middle+1;right<=nums.length-1;right++){
                    flash=Math.min(targetCloset,Math.abs(nums[left]+nums[middle]+nums[right]-target));
                    if(flash!=targetCloset){
                        result = nums[left]+nums[middle]+nums[right];
                    }
                    targetCloset=flash;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums= {1,2,4,8,16,32,64,128};
        int target = 82;
        int result = new threeSumClosest().threeSumClosest(nums, target);
        System.out.println(result);
    }
}
