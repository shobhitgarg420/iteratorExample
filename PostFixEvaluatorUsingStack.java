import java.util.Scanner;
import java.util.Stack;

public class PostFixEvaluatorUsingStack {
    public static void main(String arg[]) {
        Stack<Integer> s = new Stack<Integer>();
        Scanner in = new Scanner(System.in);

        String exp = in.nextLine();
       //Write your code here
        evaluateExpression(s,exp);
    }

    private static void evaluateExpression(Stack<Integer> stack, String exp) {
        int operator1;
        int operator2;
        int answer=0;

        /*
        1) Iterate through each element of the postfix expression.
           - If the element is an operand, then push it to the stack.
           - If the element is an operator, then pop two elements from the stack and
             apply that operator on those two elements and push the result
             back into the stack.
         2) If you reach the end of the postfix expression, then the value in the stack
             is the final answer.
        */
        for (char c:exp.toCharArray()){
            if (Character.isDigit(c))
                stack.push(c - '0');
            else{
               operator1=stack.pop();
               operator2=stack.pop();

               answer=calculateAnswer(operator1,operator2,c);
               stack.push(answer);
            }
        }
        System.out.println(stack.pop());
    }

    private static int calculateAnswer(int operator1, int operator2, char c) {
        switch (c){
            case '+':
                return operator2 + operator1;
            case '-':
                return operator2 - operator1;
            case '*':
                return operator2 * operator1;
            case '/':
                return operator2 / operator1;
            case '^':
                return (int) Math.pow(operator1,operator2);
        }
        return -1;
    }
}
