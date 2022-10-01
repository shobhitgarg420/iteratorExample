import java.util.*;

public class StackExample {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        String data=s.nextLine();
        printReverseString(data);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        printFifthElementFromStart(stack);

        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(2);
        stack1.push(14);
        stack1.push(23);
        stack1.pop();
        stack1.push(12);

        //Write your code here. Your stack should finally look like this: [2, 45, 53, 54, 12].
        while (stack1.isEmpty()==false) {
            stack1.peek();
            stack1.pop();
        }
        stack1.push(2);
        stack1.push(45);
        stack1.push(53);
        stack1.push(54);
        stack1.push(12);
        System.out.print(stack1);
    }

    static void printReverseString(String data){
        Stack<Character> s1=new Stack<Character>();
        for (int i=0;i<data.length();i++){
            s1.push(data.charAt(i));
        }

        while (s1.isEmpty()==false) {
            System.out.print(s1.peek());
            s1.pop();
        }
    }

    // Method to print the fifth element from the top of the stack
    static void printFifthElementFromStart(Stack<Integer> stack) {
        Stack<Integer> newStack=new Stack<Integer>();

        while (stack.isEmpty()==false){
            newStack.push(stack.peek());
            stack.pop();
        }

        if (newStack.size()<5)
            System.out.println("There are not enough elements in the stack");
        else
            System.out.println(newStack.search(5));
        }
}