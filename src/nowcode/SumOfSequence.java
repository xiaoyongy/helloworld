package nowcode;

import java.util.Scanner;

public class SumOfSequence {
    static boolean flag = true;
    //运用数列求和方法
    public int[] array(int N, int L){
        int[] count= new int[2]; //用于记录返回的序列的第一位数和序列的长度
        int first=0,length=0;
        for(int i = L;i<=100;i++){
            if((2*N+i-i*i)%(2*i)==0){
                length = i;
                first = (2*N+i-i*i)/(2*i);
                if(first<0) flag = false;
                break;
            }
        }
        if(length == 0) flag = false;
        count[0]=length; //记录长度
        count[1] = first; //记录序列第一位数
        return count;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int L = in.nextInt();
        int[] arr = new SumOfSequence().array(N, L);
        if(flag){
            int first = arr[1];
            for(int i = 1;i<arr[0];i++){
                System.out.print(first++ + " ");
            }
            System.out.print(first);
        }else{
            System.out.println("No");
        }
    }
}
