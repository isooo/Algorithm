package ch04;

public class Q02<E> {
    private int max;
    private int ptr;
    private E[] stk;

    public static class EmptyQ02Exception extends RuntimeException {
        public EmptyQ02Exception() {
        }
    }

    public static class OverflowQ02Exception extends RuntimeException {
        public OverflowQ02Exception() {
        }
    }

    public Q02(int capacity) {
        this.ptr = 0;
        this.max = capacity;
        try {
            stk = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E push(E e) throws OverflowQ02Exception {
        if (ptr >= max) {
            throw new OverflowQ02Exception();
        }
        return stk[ptr++] = e;
    }

    public E pop() throws EmptyQ02Exception {
        if (ptr <= 0) {
            throw new EmptyQ02Exception();
        }
        return stk[--ptr];
    }

    public E peek() throws EmptyQ02Exception {
        if (ptr <= 0) {
            throw new EmptyQ02Exception();
        }
        return stk[ptr - 1];
    }

    public int indexOf(E x) {
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        ptr = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    public void dump() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + "  ");
            }
            System.out.println();
        }
    }
}