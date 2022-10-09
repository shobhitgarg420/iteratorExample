import java.util.Scanner;
import java.util.Stack;

public class InfixtoPostfix {
    public static void main(String arg[]) {
        Stack<Character> s = new Stack<Character>();
        Scanner in = new Scanner(System.in);

        String exp = in.nextLine();
        //Write your code here
        infixToPostfixConversion(exp,s);
    }

    private static void infixToPostfixConversion(String exp, Stack<Character> stack) {
        String answer="";
        /*
        Iterate through the infix expression:
          - If the element is an operand, then add it to the answer.
          - Else, if the element is ‘(’, then push it to the stack.
          - Else, if the element is ‘)’, then pop it from the stack and
            add it to the answer until the popped element is ‘(’.
          - Else, if the element is an operator, then:
            - If the precedence of the top of the stack is less than the precedence of
              the element, or if the stack is empty, then push that element to the stack.
            - Otherwise, pop the operator from the stack and add it to the answer until the precedence of the element is less than or equal to the precedence of the top of the stack.
            - Repeat Step 1 till you reach the end of the given infix expression.

        If the stack is not empty, then pop the stack and add to the answer
        until the stack is empty.
        */

        for (char c: exp.toCharArray() ){
            if (Character.isLetterOrDigit(c))
                answer+=c;
            else if (c=='(')
                stack.push(c);
            else if (c==')'){
                while (stack.peek()!='(' && !stack.isEmpty())
                    answer+=stack.pop();
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    answer+=stack.pop();

                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            answer += stack.peek();
            stack.pop();
        }
        System.out.println(answer);
    }

    private static int Prec(char ch) {
            switch (ch) {
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
    }
