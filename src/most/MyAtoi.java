package most;

public class MyAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        int len = str.length(),index = 0, flag = 1, res = 0;
        if (len>0){
            if(str.charAt(index)=='-'){
                index++;
                flag=-1;
            }else if(str.charAt(index)=='+'){
                index++;
            }
        }
        while(index<len){
            if(str.charAt(index)>'9'||str.charAt(index)<'0') break;
            int temp = Integer.parseInt(String.valueOf(str.charAt(index)));
            if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&temp>7)) return Integer.MAX_VALUE;
            if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&temp>8)) return Integer.MIN_VALUE;
            res = res*10+temp*flag;
            index++;
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "";
        int result = new MyAtoi().myAtoi(s);
        System.out.println(result);
    }
}
