package nowcode.interview;

import java.util.Scanner;

class chicken_farm{
    public int fin(int n, int m, int k, int[] array){
        for (int i = 0;i<m;i++){
            int index = 0;
            for (int j = 0;j<n;j++){
                array[j] += k;
                if (array[index] < array[j]){
                    index = j;
                }
            }
            array[index] = array[index]/2;
        }
        int sum = 0;
        for (int i:array){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] array = new int[n];
        for (int i = 0;i<n;i++){
            array[i] = in.nextInt();
        }
        int res = new chicken_farm().fin(n, m, k, array);
        System.out.println(res);
    }
}
