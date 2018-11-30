package ch04;

/*
    제네릭 큐(링 버퍼(ring buffer)를 사용)
 */
public class Q06 {

    public static void main(String[] args) {

    }
}

class GQueue<E> {
    private int max;        // 큐 용량
    private int front;      // 첫 번째 요소 커서
    private int rear;       // 마지막 요소 커서
    private int num;        // 현재 데이터 수
    private E [] que;      // 큐 본체

    public static class EmptyGQueueException extends RuntimeException {
        public EmptyGQueueException() {
        }
    }

    // 실행할 때 예외：큐가 가득 참
    public static class OverflowGQueueException extends RuntimeException {
        public OverflowGQueueException() {
        }
    }

    public GQueue(int capacity) {
        this.max = capacity;
        num = front = rear = 0;
        try {
            que = (E[])new Object[max];
        } catch(OutOfMemoryError e) {
            max = 0;
        }
    }

    public E enque(E x) throws OverflowGQueueException {
        if(num >= max) {
            throw new OverflowGQueueException();
        }
        que[rear++] = x;
        num++;
        if(rear == max) {
            rear = 0;
        }
        return x;
    }

    public E deque() throws EmptyGQueueException {
        if(num <= 0) {
            throw new EmptyGQueueException();
        }
        E x = que[front++];
        num--;
        if(front == max) {
            front = 0;
        }
        return x;
    }

    public E peek() throws EmptyGQueueException {
        if(num <= 0) {
            throw new EmptyGQueueException();
        }
        return que[front];
    }

    public int indexOf(E x) {
        for(int i = 0 ; i < num ; i++) {
            int idx = (i + front) % max;
            if(que[idx] == x) {
                return idx;
            }
        }
        return -1;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if(num <= 0) {
            System.out.println("큐가 비어있습니다.");
        } else {
            System.out.print("[ ");
            for(int i = 0 ; i < num ; i++) {
                System.out.println(que[(i + front) % max].toString() + " ");
            }
            System.out.print(" ]");
        }
    }

    public int search(E x) {
        for(int i = 0 ; i < num ; i++) {
            if(que[(i + front) % max] == x) {
                return (i + 1);
            }
        }
        return 0;
    }
}
