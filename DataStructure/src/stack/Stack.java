package stack;

/**
 * @author isoo
 * <p>Stack 구현</p>
 */
public class Stack {

    private Node top;
    private int size = 0;

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

    
    public void pop(){

    	if (isEmpty()) {
    		System.out.println("There is no Node to pop()");
    		return;
    	} else {
    		
    		Node hasNext = this.top;
    		Node newTop = hasNext;
    		while (hasNext.getNext() != null) {
    			newTop = hasNext;
    			hasNext = hasNext.getNext();
    		}// while
    		newTop.setNext(null);
    	}// else
    	
    	this.size--;
    	printStack();
    }// pop()

    
    public Node peek(){

    	Node result = this.top;
    	
    	if (isEmpty()) {
    		System.out.println("There is no Node");
    		result = null;
    	} else {
    		while (result.getNext() != null) {
    			result = result.getNext();
    		}// while 
    	}// else
    	return result;
    }// peek()

    
    public boolean isEmpty(){
    	return this.size == 0;
    }// isEmpty()
    
    
    public void printStack() {
    	
    	Node hasNext = this.top;
    	System.out.println("stack(" + this.size + ") : ");
    	System.out.print(" \tbottom [ ");
    	
    	do {
    		System.out.print(" " + hasNext.getValue() + " ");
    		hasNext = hasNext.getNext();
    	} while (hasNext != null);
    	
    	System.out.print(" ] top \n\n");
    		
    }// printStack()
    
}
