package queue;

public class Queue {
    private Node head;
    private int front;
    private int rear;

    /**
     * Constructor
     *  head 선언 및 front, rear 초기화
     */
    public Queue(){
        this.head   = new Node();
        this.front  = -1;
        this.rear   = -1;
    }

    /**
     * 데이터 입력
     * @param input
     */
    public void enQueue(Node input){
        if( isEmpty() ) {
            this.head.setNext( input );
            this.rear++;
            System.out.println("SUCCESS ENQUEUE:::: " + input.getValue() + "");
        }
        else {
            Node tmp = this.head;
            for( int i = this.front; i < this.rear; i++ ) {
                tmp = tmp.getNext();
            }
            tmp.setNext( input );
            this.rear++;
            System.out.println("SUCCESS ENQUEUE:::: " + input.getValue() + "");
        }
        printQueue();
    }

    /**
     * latest 데이터 리턴 및 삭제
     * @return
     */
    public Node deQueue(){
        if( isEmpty() ){
            System.out.println("ERROR::::Queue is Empty");
            return null;
        }
        else {
            Node resultNode = this.head.getNext();
            this.head.setNext(resultNode.getNext());
            this.rear--;

            System.out.println("SUCCESS DEQUEUE:::: " + resultNode.getValue() + "");
            printQueue();

            return resultNode;
        }
    }

    /**
     * latest 데이터 리턴
     * @return
     */
    public Node element(){
        if( isEmpty() ){
            System.out.println("ERROR::::Queue is Empty");
            return null;
        } else {
            Node resultNode = this.head.getNext();

            System.out.println("SUCCESS ELEMENT::::" + resultNode.getValue());
            printQueue();

            return resultNode;
        }
    }

    private boolean isEmpty(){
        if( this.front >= this.rear ) {
            return true;
        }
        else
            return false;
    }

    private void printQueue(){
        if( isEmpty() ){
            System.out.println("PRINT QUEUE:::: Queue is Empty");
            return ;
        } else {
            Node tmp = this.head.getNext();

            System.out.print("PRINT QUEUE::::");
            while( tmp != null ){
                System.out.print( tmp.getValue() + " " );
                tmp = tmp.getNext();
            }
            System.out.println();
        }
    }
}
