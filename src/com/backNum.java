package com;


public class backNum {
    private boolean isPalindrome1(int x){
        String s = x + "";
        int mid = s.length()/2, i = 1;
        if(s.length()%2 == 1){
            while (mid-i>-1&& s.charAt(mid-i) == s.charAt(mid+i)){
                i++;
            }
        }
        if(s.length()%2 == 0){
            while (mid-i>-1&&s.charAt(mid+i-1) == s.charAt(mid-i)){
                i ++;
            }
        }
        return mid - i == -1;
    }

    private boolean isPalindrome2(int num){
        if(num<0||(num%10==0&&num!=0))
            return false;
        int res = 0;
        while (num>res){
            res = res*10+num%10;
            num /= 10;
        }
        return res==num || res/10 == num;
    }

    public static void main(String[] args) {
        int num = 23456432;
        boolean result1 = new backNum().isPalindrome1(num);
        boolean result2 = new backNum().isPalindrome2(num);
        System.out.println(result2);
    }
}
