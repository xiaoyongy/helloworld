package most;
import java.lang.String;

public class SayCount {
    public String CountNum(int n){
        if(n<1) return "Error number";
        String preResult="1";
       for(int i=1;i<n;i++){
           String str = "";
           int count = 1;
           for(int j = 0;j<preResult.length();j++){
               if(j+1<preResult.length()&&preResult.charAt(j)==preResult.charAt(j+1)){
                   count++;
               }else{
                   str += count;
                   str += preResult.charAt(j);
                   count = 1;
               }
           }
           preResult = str;
       }
       return preResult;
        /*String s = "1";
        for (int i = 1; i < n; i++) {
            int count = 1;
            String str = "";
            for (int j = 0; j < s.length(); j++) {
                //这里一定是if else的判断，有重复值一定先计算出重复值，因为else里面是先加上重复值
                if (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                } else {
                    str += count;
                    str += s.charAt(j);
                    count = 1;
                }
            }
            s = str;
        }
        return s;*/
    }
    public String CountAndSay(int n){
        String preResult = "1";
        for(int i=1;i<n;i++){
            String str = "";
            int count=1;
            for(int j=0;j<preResult.length();j++){
                if(j+1<preResult.length()&&preResult.charAt(j)==preResult.charAt(j+1)){
                    count++;
                }else {
                    str = str + count;
                    str = str + preResult.charAt(j);
                    count=1;
                }
            }
            preResult = str;
        }
        return preResult;
    }
    public static void main(String[] args){
        String result = new SayCount().CountAndSay(4);
        System.out.println(result);
    }
}
