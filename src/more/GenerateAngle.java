package more;

import java.util.*;
import java.util.Arrays;

public class GenerateAngle {
    public List<List<Integer>> generateAngle(int n){
        List<List<Integer>> result = new ArrayList<>();
        if (n<=0) return result;
        for (int i=0;i<n;i++){
            List<Integer> list = Arrays.asList(new Integer[i+1]);
//            在list数组0和i位置都设置为1
            list.set(0,1);
            list.set(i,1);
            for (int k=1;k<i;k++){
//                这一行代码是算法的关键
                list.set(k,result.get(i-1).get(k)+result.get(i-1).get(k-1));
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        List<List<Integer>> result = new GenerateAngle().generateAngle(nums);
        System.out.println(result);
    }
}
