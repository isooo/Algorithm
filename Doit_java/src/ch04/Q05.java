package ch04;

/*
    int형 큐(링 버퍼(ring buffer)를 사용)
 */
public class Q05 {

    public static void main(String[] args) {

    }
}

class IntQueue {
    private int max;        // 큐 용량
    private int front;      // 첫 번째 요소 커서
    private int rear;       // 마지막 요소 커서
    private int num;        // 현재 데이터 수
    private int[] que;      // 큐 본체

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {
        }
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {
        }
    }

    public IntQueue(int capacity) {
        this.max = capacity;
        num = front = rear = 0;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException {
        if (num >= max) {
            throw new OverflowIntQueueException();
        }
        que[rear++] = x;
        num++;
        if (rear == max) {
            rear = 0;
        }
        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        int x = que[front++];
        num--;
        if (front == max) {
            front = 0;
        }
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x) {
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
        if (num <= 0) {
            System.out.println("큐가 비어있습니다.");
        } else {
            System.out.print("[ ");
            for (int i = 0; i < num; i++) {
                System.out.println(que[(i + front) % max] + " ");
            }
            System.out.print(" ]");
        }
    }

    public int search(int x) {
        for (int i = 0; i < num; i++) {
            if (que[(i + front) % max] == x) {
                return (i + 1);
            }
        }
        return 0;
    }
}
