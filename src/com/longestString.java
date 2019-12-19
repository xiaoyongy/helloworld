package com;

import java.util.HashSet;
import java.util.Set;

public class longestString {
    private int lengthOfLongestSubstring(String s){
//        int l = 0, r = -1;
//        int res = 0;
//        Set<Character> set = new HashSet<>();
//        while (r < s.length()){
//            if (l < s.length() && freq[r+1]==0){
//                r++;
//
//                freq[s[r]]++;
//            }else {
//                freq[s[l]]--;
//                l++;
//            }
//            res = max(res, r-l+1);
//        }
        int n = s.length();
        int res = 0;
        int end=0,start=0;
        Set<Character> set=new HashSet<>();
        while(start<n && end<n){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));
            }else{
                set.add(s.charAt(end++));
                res=Math.max(res,end-start);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "shehepwpwktpyk";
        int result = new longestString().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
