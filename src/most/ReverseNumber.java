package most;

public class ReverseNumber {
    public int reverse(int x) {
        long xRev = 0;
        while(x!=0){
            int temp = x%10;
            xRev = xRev*10+temp;
            x /=10;
        }
//        if(x<0) xRev=-xRev;
        if(xRev>2147483647||xRev<-2147483648) return 0;
        return (int) xRev;
    }

    public static void main(String[] args) {
        int x = 1534236469;
        int result = new ReverseNumber().reverse(x);
        System.out.println(result);
    }
}
