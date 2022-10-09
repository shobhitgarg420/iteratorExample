import java.util.Scanner;
import java.util.Stack;

public class EvaluatePrefixUsingStack {
    private static int computeResult(String exp) {
        String newString = "";
        char ch=' ';

        //reverse the string/expression first
        for (int i=0;i<exp.length();i++){
            ch=exp.charAt(i);
            newString=ch+newString;
        }

        Stack<Integer> stack=new Stack<>();
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
        for (char c: newString.toCharArray()){
            if (Character.isDigit(c))
                stack.push(c - '0');
            else if (c=='(' || c==')' || c==' ')
                continue;
            else{
                if (!stack.isEmpty()) {
                    operator1 = stack.pop();
                    operator2 = stack.pop();

                    answer = calculateAnswer(operator1, operator2, c);
                    stack.push(answer);
                }
            }
        }
        return answer;
    }

    private static int calculateAnswer(int operator1, int operator2, char c) {
        switch (c){
            case '+':
                return operator2 + operator1;
            case '-':
                return operator1 - operator2;
            case '*':
                return operator2 * operator1;
            case '/':
                return operator1 / operator2;
            case '^':
                return (int) Math.pow(operator1,operator2);
        }
        return -1;
    }

    public static void main(String arg[]) {
        EvaluatePrefixUsingStack obj=new EvaluatePrefixUsingStack();
        Scanner in=new Scanner(System.in);
        String inputString=in.nextLine();
        int result=obj.computeResult(inputString);
        System.out.println(result);
    }
}
