package stack;

/**
 * @author isoo
 * <p>Stack 구현</p>
 */
public class Stack {

    private Node top;
    private static int size = 0;

    /**
     * @param input
     *
     * <p>
     * 		isEmpty() == true 면
     * 		input된 Node를 top에 대입.
     * 		isEmpty() == false 면
     * 		Node top 부터 반복문 돌려서 next가 null인 Node가 나오면
     * 		inpit된 Node를 대입.
     * </p>
     */
    public void push(String inputValue){
    	
    	Node input = new Node(inputValue);
    	
    	if (isEmpty()) {
    		top = input;
    	} else {
    		Node prevNode = this.top;
    		while (prevNode.getNext() != null) {
    			prevNode = prevNode.getNext();
    		}// while
    		prevNode.setNext(input);
    	}// else
    	
    	this.size++;
    	printStack();
    }// push()

    public Node pop(){

    }

    public Node peek(){

    }

    public boolean isEmpty(){
    	return this.size == 0;
    }// isEmpty()
    
    
    public void printStack() {
    	
    	Node hasNext = this.top;
    	
    	System.out.print("bottom [ ");
    	
    	do {
    		System.out.print(" " + hasNext.getValue() + " ");
    		hasNext = hasNext.getNext();
    	} while (hasNext != null);
    	
    	System.out.print(" ] top \n");
    		
    }// printStack()
    
}
