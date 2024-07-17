package Stack;

import java.util.Stack;

public class InfixToPostFix {

    public int priority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

        }
        return -1;
    }

    public boolean isOperand(char ch) {
        return (ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9');
    }


    public String infixToPostfix(String infix) {

        StringBuilder postFix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        //operand -> Opening bracket -> closing -> operator
        for(char ch : infix.toCharArray()) {
            if(isOperand(ch)) {
                postFix.append(ch);
            } else if(ch=='(') {
                stack.push('(');
            } else if(ch==')') {
                while(!stack.isEmpty() && stack.peek()!='(') {
                    postFix.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && priority(stack.peek())>=priority(ch)) {
                    postFix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postFix.append(stack.pop());
        }

        return postFix.toString();
    }

    public static class StockSpan {

        //[100, 80,110, 40, 12
        public static int[] stockSpan(int[] stock) {
            int n = stock.length;
            Stack<Integer> stack = new Stack<>();
            int[] result = new int[n];

            for(int i=0;i<n;i++) {

                while (!stack.isEmpty() && stock[stack.peek()] <= stock[i]) {
                    stack.pop();
                }
                result[i] = stack.isEmpty() ? i+1 : i -stack.peek();
                stack.push(i);
            }
            return result;
        }

        public static void main(String[] args) {
            int[] arr = {100,80,60,70,60,75,85};
            int[] result = stockSpan(arr);
            for(int x: result)
                System.out.print(x + " ");
        }
    }
}
