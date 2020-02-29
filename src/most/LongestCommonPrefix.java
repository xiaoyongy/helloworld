package most;

public class LongestCommonPrefix {
    /*执行用时:击败18.25%用户
    内存消耗；击败36.36%用户*/
    public String longestConmmonPrefix(String[] strs){
        if(strs.length==0) return "";
        String preFix = strs[0];
        for(int i = 1;i<strs.length;i++){
            String secFix = strs[i];
            int index = 0;
            for(;index<preFix.length()&&index<secFix.length();index++){
                if(preFix.charAt(index)!=secFix.charAt(index)){
                    break;
                }
            }
            preFix = strs[i].substring(0,index);
        }
        return preFix;
    }
    /*执行用时0ms：击败100%用户
    内存消耗37.5MB：击败45.74%用户*/
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static void main(String[] args) {
        String s = "pre";
        String s1 = "pre";
        String[] strs = {"flower","flow","flight"};
        String res = new LongestCommonPrefix().longestCommonPrefix1(strs);
//        System.out.println(res);
        System.out.println(s.indexOf(s1));
    }
}
