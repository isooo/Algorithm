package stack;

public class TestMain {
	
	public static void main(String[] args) {
		
		Stack stack = new Stack();
		
		stack.push("one");
		stack.push("two");
		stack.push("three");
		
		Node peekNode = stack.peek();
		System.out.println("stack.peek() ==> " + peekNode.getValue());
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

	}// main()

}
