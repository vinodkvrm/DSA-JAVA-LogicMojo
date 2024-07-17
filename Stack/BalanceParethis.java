package Stack;

import java.util.Stack;

class BalanceParethis {
    
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
         for(char ch : s.toCharArray()){
            if( ch == '(' )
                stack.push(')');
            else if(ch == '{')
                stack.push('}');
            else if(ch == '[')
                stack.push(']');       
            else if(stack.isEmpty() || stack.pop() != ch){                
                return false;                
            }
         }
         return stack.isEmpty();
    }

    public static void main(String[] args) {
        BalanceParethis balanceParethis = new BalanceParethis();
        System.out.println(balanceParethis.isValid("()"));
        System.out.println(balanceParethis.isValid("()[]{}"));
        System.out.println(balanceParethis.isValid("(]"));
        System.out.println(balanceParethis.isValid("([)]"));
        System.out.println(balanceParethis.isValid("{[]}"));
    }
}