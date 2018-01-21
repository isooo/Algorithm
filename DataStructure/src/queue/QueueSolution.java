package queue;

public class QueueSolution {
    public static void main ( String[] args ) {
        Queue queue = new Queue();

        queue.enQueue( new Node(1) );

        queue.enQueue( new Node(2) );

        queue.element();

        queue.deQueue();

        queue.element();

        queue.deQueue();

        queue.enQueue( new Node(3) );

        queue.element();

        queue.enQueue( new Node(4) );

        queue.deQueue();

        queue.enQueue(new Node(5));

        queue.deQueue();

        queue.deQueue();

        // This will print Error Message
        queue.deQueue();
    }
}
