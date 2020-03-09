package nowcode;

public class MinRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;
        int left= 0,right = array.length-1, indexMid = 0;
        while(array[left]>array[right]){
            if(right-left==1){
                indexMid = right;
                break;
            }
            indexMid = left+(right-left)/2;
            if(array[left]==array[right]&&array[right]==array[indexMid]){
                return specialNumber(array);
            }
            if(array[left]>array[indexMid]){
                right = indexMid;
            }else{
                left = indexMid;
            }
        }
        return array[indexMid];
    }
    //还有查找特例方法
    public int specialNumber(int[] array){
        int res = array[0];
        for(int temp:array){
            res = Math.min(temp,res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {6501,6828,6963,7036,7422,7674,154,293,334,492,1323,1479,1539,1727,1870,1943,2383};
        int res = new MinRotateArray().minNumberInRotateArray(array);
        System.out.println(res);
    }
}
