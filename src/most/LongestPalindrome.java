package most;

public class LongestPalindrome {
//    public boolean Palindrome(String str){
//        int len = str.length()-1;
//        if(len==0) return true;
//        for(int i=0;i<len-i;i++){
//            if(str.charAt(i)!=str.charAt(len-i)){
//                break;
//            }
//        }
//        return true;
//    }
//    public String longestPalindrome(String s) {
//        if(s==null) return s;
//        int len = s.length()-1;
//        String longestString = "";
//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<=len&&max<=(len-i);i++){
//            for(int j=len;j>=i;j--){
//                String sTemp = s.substring(i,j+1);
//                boolean flag = Palindrome(sTemp);
//                if(flag){
//                    int maxTemp = Math.max(max, sTemp.length());
//                    if(maxTemp!=max){
//                        longestString = sTemp;
//                        max = maxTemp;
//                        break;
//                    }
//                }
//            }
//        }
//        return longestString;
//    }
    public String centerSpread(String str, int i, int j){
        int len = str.length();
        int left = i, right = j;
        while (left>-1&&right<len){
            if (str.charAt(left)==str.charAt(right)){
                left--;
                right++;
            }else break;
        }
        return str.substring(left+1, right);
    }
    public String longestPalindrome(String s){
        int len = s.length();
        if (len<2) return s;
        String res = s.substring(0, 1);
        int max = Integer.MIN_VALUE;
        int flag = Integer.MIN_VALUE;
        for (int i = 0;i<len-1;i++){
            String left = centerSpread(s, i, i);
            String right = centerSpread(s, i, i+1);
            max = Math.max(left.length(), right.length());
            if (max>flag){
                res = left.length()>right.length()?left:right;
                flag = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abdbibf";
        String res = new LongestPalindrome().longestPalindrome(s);
        System.out.println(res);
    }

}
