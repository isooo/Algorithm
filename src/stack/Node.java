package stack;
<<<<<<< HEAD:DataStructure/src/stack/Node.java

=======
>>>>>>> b2eda9f6babddf326902794ecfbf9b8711c73373:src/stack/Node.java

public class Node {
    private Object value;
    private Node next;

    public Node(){
        this.value = null;
        this.next = null;
    }

    public Node(Object value){
        this.value = value;
        this.next = null;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
