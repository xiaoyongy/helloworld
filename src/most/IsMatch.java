package most;
/*https://mp.weixin.qq.com/s/ZoytuPt5dfP5pMODbuKnCQ
正则表达式匹配有多种解法*/
public class IsMatch {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) return true;
        boolean isFirstMatch = false;
        if(!s.isEmpty()&&!p.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')){
            isFirstMatch = true;
        }
        if(p.length()>=2&&p.charAt(1)=='*'){
            return isMatch(s, p.substring(2))||(isFirstMatch&&isMatch(s.substring(1),p));
        }
        return isFirstMatch&&isMatch(s.substring(1), p.substring(1));
    }
}
