package ch04;

/*
    int형 큐(링 버퍼(ring buffer)를 사용하지 않음)
 */
public class Q04 {

    public static void main(String[] args) {

        IntAryQueue tmp = new IntAryQueue(5);
        tmp.enqueue(5);
        tmp.enqueue(9);
        tmp.enqueue(3);
        tmp.enqueue(1);

        tmp.dequeue();

        tmp.enqueue(12);
        tmp.enqueue(512);

        tmp.dequeue();
        tmp.dequeue();
    }
}

class IntAryQueue {
    private int max;        // 큐 용량
    private int num;        // 현재 데이터 수
    private int[] que;      // 큐 본체

    public IntAryQueue(int capacity) {
        this.max = capacity;
        this.num = 0;
        try{
            que = new int[max];
        } catch(OutOfMemoryError e) {
            max = 0;
        }
    }

    // 실행할 때 예외：큐가 비어 있음
    public class EmptyIntAryQueueException extends RuntimeException {
        public EmptyIntAryQueueException() {
        }
    }

    // 실행할 때 예외：큐가 가득 참
    public class OverflowIntAryQueueException extends RuntimeException {
        public OverflowIntAryQueueException() {
        }
    }

    public int enqueue(int n) throws OverflowIntAryQueueException {
        if (num >= max) {
            throw new OverflowIntAryQueueException();
        }
        que[num++] = n;
        dump();
        return n;
    }

    public int dequeue() throws EmptyIntAryQueueException {
        if(num <= 0) {
            throw new EmptyIntAryQueueException();
        }
        int result = que[0];
        for(int i = 0 ; i < num - 1 ; i++) {
            que[i] = que[i+1];
        }
        num--;
        dump();
        return result;
    }

    // 큐에서 데이터를 피크(리어쪽 데이터를 살펴봄)
    public int rear() throws EmptyIntAryQueueException {
        if(num <= 0) {
            throw new EmptyIntAryQueueException();
        }
        return que[num-1];
    }

    public int indexOf(int n) {
        for(int i = 0 ; i < num ; i++) {
            if(que[i] == n) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        this.num = 0;
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
            System.out.println("큐가 비었습니다.");
        } else {
            System.out.print("[ ");
            for(int i = 0 ; i < num ; i++) {
                System.out.print(que[i] + " ");
            }
            System.out.println("]");
        }
    }
}
