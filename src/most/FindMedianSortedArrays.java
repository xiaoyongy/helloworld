package most;

public class FindMedianSortedArrays {
//    public boolean isPalindrome(int x) {
//        int xTemp = x,num=1,target=0;
//        if(x<0) return false;
//        while(xTemp!=0){
//            num*=10;
//            target++;
//            xTemp/=10;
//        }
//        num/=10;
//        for(int i=0;i<target/2;i++){
//            if(x%10!=x/num) return false;
//            x /=num;
//            num/=10;
//            x %= 10;
//        }
//        return true;
//    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length,len2 = nums2.length;
        int left = (len1+len2+1)/2;
        int right = (len1+len2+2)/2;
        return (kNumber(nums1, 0, len1-1, nums2, 0, len2-1, left)+kNumber(nums1, 0, len1-1, nums2, 0, len2-1, right))/2;

    }
    public double kNumber(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k){
        int len1 = right1 - left1 + 1;
        int len2 = right2 - left2 + 1;
        if(len1>len2) return kNumber(nums2, left2, right2, nums1, left1, right1, k);
        if(len1==0) return nums2[left2+k-1];
        if(k==1) return Math.min(nums1[left1], nums2[left2]);
        int i = left1+Math.min(len1, k/2)-1;
        int j = left2+Math.min(len2, k/2)-1;
//        while(k/2<len1||k/2<len2){
//            if(k/2<len1){
//                int len1Num = nums1[left1+k/2-1];
//            }
//            if(k/2<len2){
//                int len2Num = nums2[left2+k/2-1];
//            }
//            if(len1Num>len2Num){
//                return kNumber(nums1, left1, right1, nums2, left2+k/2-1, right2, k-k/2);
//            }else{
//                return kNumber(nums1, left1+k/2-1, right1, nums2, left2, right2, k-k/2);
//            }
//        }
        if (nums1[i]>nums2[j]){
            return kNumber(nums1, left1, right1, nums2, j+1, right2, k-(j-left2+1));
        }else{
            return kNumber(nums1, i+1, right1, nums2, left2, right2, k-(i-left1+1));
        }
    }

    public static void main(String[] args) {
        int num = 1001;
        int[] num1 = {1,3,4,9};
        int[] num2 = {1,2,3,4,5,6,7,8,9,10};
        double flag = new FindMedianSortedArrays().findMedianSortedArrays(num1, num2);
        System.out.println(flag);
    }
}
