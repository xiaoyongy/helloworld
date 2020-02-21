package most;

//这题完成没有考虑到整数溢出，需要注意
public class ReverseNum {
    public static int reverse(int x){
        int temp;
        long i = 0;
        while(x!=0){
            temp = x%10;
            i = i*10+temp;
            x/=10;
        }

//        需要加入溢出的判断
        if (i>Integer.MAX_VALUE||i<Integer.MIN_VALUE)
            return 0;


        return (int)i;
    }

    public static void main(String[] args) {
        System.out.println(reverse(153423669));
    }
}