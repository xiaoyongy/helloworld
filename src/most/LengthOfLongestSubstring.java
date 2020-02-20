package most;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
//                left = Math.max(left, i);  //dvdf例子不成功，应将left设置在出现在map中出现的字符后一位
//                left = i; //这也不对
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "dvdf";
        int result = new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
