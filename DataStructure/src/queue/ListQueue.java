package queue;


//출처: http://hyeonstorage.tistory.com/263 [개발이 하고 싶어요]
public class ListQueue {

    private class Node{

        // 노드는 data와 다음 노드를 가진다.
        private Object  data;
        private Node nextNode;

        Node(Object data){
            this.data = data;
            this.nextNode = null;
        }
    }

    // 큐는 front노드와 rear노드를 가진다.
    private Node front;
    private Node rear;

    public ListQueue(){
        this.front = null;
        this.rear = null;
    }

    // 큐가 비어있는지 확인
    public boolean empty(){
        return (front==null);
    }

    // item을 큐의 rear에 넣는다.
    public void insert(Object item){

        Node node = new Node(item);
        node.nextNode = null;

        if(empty()){

            rear = node;
            front = node;

        }else{

            rear.nextNode = node;
            rear = node;

        }
    }

    // front 의 데이터를 반환한다.
    public Object peek(){
        if(empty()) throw new ArrayIndexOutOfBoundsException();
        return front.data;
    }

    // front 를 큐에서 제거한다.
    public Object remove(){

        Object item = peek();
        front = front.nextNode;

        if(front == null){
            rear = null;
        }

        return item;
    }
}

