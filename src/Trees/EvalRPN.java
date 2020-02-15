package Trees;

import java.util.*;

public class EvalRPN {
//    coding by myself
    public int InversePoland(String[] string){
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (String temp : string){
            int aAndB = 0;
            if (temp.equals("+")||temp.equals("-")||temp.equals("*")||temp.equals("/")){
                int tempA = stack.pop();
                int tempB = stack.pop();
                switch (temp){
                    case "+":aAndB = tempB+tempA;break;
                    case "-":aAndB = tempB-tempA;break;
                    case "*":aAndB = tempB*tempA;break;
                    case "/":aAndB = tempB/tempA;break;
                }
                stack.push(aAndB);
                result = aAndB;
            }else {
                stack.push(Integer.parseInt(temp));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] string = {"2", "1", "+", "3", "*"};
        int result = new EvalRPN().InversePoland(string);
        System.out.println(result);
    }
}
