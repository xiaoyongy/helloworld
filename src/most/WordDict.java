package most;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDict {
//    判断字符串中是否有子串与列表中的词匹配
    public boolean wordDict(String str, ArrayList<String> list){
        for (String strTemp : list) {
            int len = strTemp.length();
            for (int j = 0; len < str.length(); j++) {
                if (strTemp.equals(str.substring(j, len++)))
                    return true;
            }
        }
        return false;
    }
//    一个非空字符串和一个包含非空单词列表字典，判定字符串是否可以被空格拆分为一个或多个在字典中出现的单词
    public boolean wordDict2(String str, ArrayList<String> wordDict){
        int len = str.length();
        int maxLength = 0;
        for (String temp:wordDict){
            maxLength = Math.max(temp.length(), maxLength);
        }
        boolean[] meno = new boolean[len+1];
        meno[0] = true;
        for (int i=1;i<=len;i++){
            for (int j = i-1;j>=0&&(i-j)<=maxLength;j--){
                if (meno[j] && wordDict.contains(str.substring(j, i))) {
                    meno[i] = true;
                    break;
                }
            }
        }
        return meno[len];
    }
//        https://www.cnblogs.com/yanhowever/p/10950763.html
    private Map<String, List<String>> map = new HashMap<>();
    private List<String> wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s)) //如果包含 则直接返回s
            return map.get(s);
        List<String> list = new ArrayList<>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {//判断s是否含有word的前缀
                List<String> tmpList = wordBreak(s.substring(word.length()), wordDict);
                for (String tmp : tmpList)
                    list.add(word + (tmp.equals("") ? "" : " ") + tmp);//空的话则""结尾
            }
        }
        map.put(s, list);//记录可以拆分的字符串，并且记录拆分的方法
        return list;
    }

    public static void main(String[] args) {
        String str = "catsanddog";
        List<String> list = new ArrayList<>();
//        list.add("cats");
        list.add("dog");
        list.add("sand");
//        list.add("and");
        list.add("cat");
        list.add("sanddog");
//        boolean flash = new WordDict().wordDict2(str, list);
        List<String> listBreak = new WordDict().wordBreak(str, list);
        System.out.println(list);
        System.out.println(listBreak);
    }
}
