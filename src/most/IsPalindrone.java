package most;

public class IsPalindrone {
    public boolean isPalindrome(String s){
        if (s.isEmpty()) return true;
        int left = 0,right = s.length()-1;
        while (left<right){
            if (!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }else if (!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }else {
                if (Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))) return false;
//                if (CharUtils.isAlpha) 这是lang库的工具类
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        对于Character.toLowerCase方法，因为Java天生提供了对Unicode的支持，因此在他眼里中文也是“letter”，所以下面的字符串也是返回true
        String str = "中A man, a plan, a canal: Panama中";
        String str1 = "race a car";
        boolean flag = new IsPalindrone().isPalindrome(str);
        System.out.println(flag);
    }
}
