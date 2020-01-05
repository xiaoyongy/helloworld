package more;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MatchBlock {

    static  boolean isMatch(String s){
        //定义左右括号的对应关系
        Map<Character,Character> bracket  = new HashMap<>();
        bracket.put(')','(');
        bracket.put(']','[');
        bracket.put('}','{');
        System.out.println(bracket);

        Stack stack = new Stack();

        for(int i = 0; i < s.length(); i++){

            Character temp = s.charAt(i);//先转换成字符
            //是否为左括号
            if(bracket.containsValue(temp)){

                stack.push(temp);
                //是否为右括号
            }else if(bracket.containsKey(temp)){
                if(stack.isEmpty()){
                    return false;
                }
                //若左右括号匹配
//                需要先判断左右括号是否匹配
                if(stack.peek() == bracket.get(temp)){
                    stack.pop();
                }
                else{
                    return false;
                }
            }

        }
        return stack.isEmpty()? true: false;

    }


    public static void main(String[] args) {

        System.out.println(isMatch("(***)-[{-------}]][")); //true
        System.out.println(isMatch("(2+4)*a[5]")); //true
        System.out.println(isMatch("({}[]]])")); //false
        System.out.println(isMatch("())))")); //false

    }
}

