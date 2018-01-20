
package com.acorn.stack;


public class  Stack {

    private Node head;
    private int top;

    public Stack(){
        this.head   = new Node();
        this.top    = -1;
    }

    public void push(Node input){
        if(isEmpty()) {
            this.head.setNext(input);
            this.top++;
            System.out.println("PUSH:::: Push node" + input.getValue() + " || Current top " + this.top);
        } else {
            Node tmp = this.head;
            for(int i = 0; i <= this.top; i++)  tmp = tmp.getNext();
            tmp.setNext(input);
            this.top++;
            
            System.out.println("PUSH:::: Push node" + input.getValue() + " || Current top " + this.top);
        }
        printStack();
    }

    public Node pop(){
        Node result = null;
        
        if(isEmpty()) {
            System.out.println("Error:::: Stack is Empty");
        } else {
            Node prev = this.head;
            Node tmp = this.head.getNext();
            for(int i = 0; i < this.top; i++){
                prev = prev.getNext();
                tmp = tmp.getNext();
            }
            result = tmp;
            prev.setNext(null);
            this.top--;

            System.out.println("POP:::: Pop node " + result.getValue() + " || Current top " + this.top);
        }
        printStack();
        
        return result;
    }

    public Node peek(){
        Node result = null;
    
        if(isEmpty()) {
            System.out.println("Error:::: Stack is Empty");
        } else {
            Node tmp = this.head.getNext();
            for(int i = 0; i < this.top; i++){
                tmp = tmp.getNext();
            }
            result = tmp;

            System.out.println("PEEK:::: Peek node " + result.getValue() + " || Current top " + this.top);
        }
        printStack();
        
        return result;
    }

    private boolean isEmpty(){
        if(this.top < 0)    return true;
        else                return false;
    }
    
    private void printStack(){
        if(isEmpty()) {
            System.out.println("PrintStack:::: Stack is Empty");
        } else {
            Node tmp = this.head.getNext();
            System.out.print("PrintStack::::");
            for(int i = 0; i <= this.top; i++) {
                System.out.print(tmp.getValue() + " ");
                tmp = tmp.getNext();
            }
            System.out.println();
        }
    }
}
