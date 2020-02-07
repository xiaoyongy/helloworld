package most;

import java.util.ArrayList;
import java.util.List;

public class PartitionPalindroom {
    List<List<String>> res = new ArrayList<>();
    public void backTracing(List<String> list, String s, int left){
        if (left==s.length()){ //当字符串的左边下标是字符串的长度时，将终止条件
            res.add(list); // 将符合回文的结果添加到res中
            return;
        }
        for (int i=left+1;i<=s.length();i++){
            if (new IsPalindrone().isPalindrome(s.substring(left, i))){
                list.add(s.substring(left, i));
//                每个backTracing方法都需要使用new初始化新的ArrayList数组
                backTracing(new ArrayList<>(list), s, i);
//                回溯，从而找到更长的回文串
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> Partition(String s){
        if (s.length()==0){
            return res;
        }
        List<String> list = new ArrayList<>();
        backTracing(list, s, 0);
        return res;
    }
    public static void main(String[] args) {
        String s = "aacbc";
        List<List<String>> result = new PartitionPalindroom().Partition(s);
        System.out.println(result);
    }
}
