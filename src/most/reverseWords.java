package most;

public class reverseWords {
    public String ReverseWords(String s){
        s = s.trim();
        if (s.equals("")) return s;
        String[] str = s.split(" ");
        StringBuilder sTemp = new StringBuilder();
        for (int i=str.length-1;i>-1;i--){
            if (str[i].equals("")) continue;
            if (i==0){
                sTemp.append(str[i]);
            }else {
                sTemp.append(str[i]).append(" ");
            }
        }
        return sTemp.toString();
    }

    public static void main(String[] args) {
        String s = "a good    example";
//        String[] str = s.split(" ");
//        StringBuilder ss = new StringBuilder();
//        for (String value : str) {
//            if (value.equals(""))
//                continue;
//            ss.append(value).append(" ");
//        }
//        ss.deleteCharAt(ss.length()-1);
//        System.out.println(ss);
        String result = new reverseWords().ReverseWords(s);
        System.out.println(result);
    }
}
