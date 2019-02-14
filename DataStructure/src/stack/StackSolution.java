package stack;

public class StackSolution {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.pop();
        stack.push(new Node(1));
        stack.push(new Node(2));
        stack.push(new Node(3));

        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();

    }
}
