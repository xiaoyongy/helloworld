package nowcode;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int len = str.length();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<len;i++){
            if(str.charAt(i)==' '){
                res.append("%20");
            }else{
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("heeo word");
        String res = new ReplaceSpace().replaceSpace(str);
        System.out.println(res);
    }
}
