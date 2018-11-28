package ch04;

public class Q03 {

    private int max;        // A와 B의 합계
    private int ptrA;
    private int ptrB;
    private int[] stk;

    public enum AorB {
        StackA, StackB
    };

    public class EmptyQ03Exception extends RuntimeException {
        public EmptyQ03Exception() {}
    }

    public class OverflowQ03Exception extends RuntimeException {
        public OverflowQ03Exception() {}
    }

    public Q03(int capacity) {
        this.ptrA = 0;
        this.ptrB = capacity - 1;
        this.max = capacity;
        try{
            stk = new int[capacity];
        } catch(OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(AorB ab, int x) throws OverflowQ03Exception {
        if (ptrA >= ptrB + 1) {
            // 스택이 가득 참
            throw new OverflowQ03Exception();
        }
        switch (ab) {
            case StackA:
                stk[ptrA++] = x;
                break;
            case StackB:
                stk[ptrB--] = x;
                break;
        }
        return x;
    }

    // 스택에서 데이터를 팝(꼭대기의 데이터를 꺼냄)
    public int pop(AorB sw) throws EmptyQ03Exception {
        int x = 0;
        switch (sw) {
            case StackA:
                if (ptrA <= 0) // 스택 A가 비어 있음
                    throw new EmptyQ03Exception();
                x = stk[--ptrA];
                break;
            case StackB:
                if (ptrB >= max - 1) // 스택 B가 비어 있음
                    throw new EmptyQ03Exception();
                x = stk[++ptrB];
                break;
        }
        return x;
    }

    // 스택에서 데이터를 피크(꼭대기의 데이터를 살펴 봄)
    public int peek(AorB sw) throws EmptyQ03Exception {
        int x = 0;
        switch (sw) {
            case StackA:
                if (ptrA <= 0) // 스택 A가 비어 있음
                    throw new EmptyQ03Exception();
                x = stk[ptrA - 1];
                break;
            case StackB:
                if (ptrB >= max - 1) // 스택 B가 비어 있음
                    throw new EmptyQ03Exception();
                x = stk[ptrB + 1];
                break;
        }
        return x;
    }

    // 스택에서 x를 검색하여 index(찾지 못하면 -1)를 반환
    public int indexOf(AorB sw, int x) {
        switch (sw) {
            case StackA:
                for (int i = ptrA - 1; i >= 0; i--) // 꼭대기쪽부터 선형 검색
                    if (stk[i] == x)
                        return i; // 검색성공
                break;
            case StackB:
                for (int i = ptrB + 1; i < max; i++) // 꼭대기쪽부터 선형 검색
                    if (stk[i] == x)
                        return i; // 검색성공
                break;
        }
        return -1; // 검색실패
    }

    // 스택을 비움
    public void clear(AorB sw) {
        switch (sw) {
            case StackA:
                ptrA = 0;
                break;
            case StackB:
                ptrB = max - 1;
                break;
        }
    }

    // 스택의 용량을 반환 (A와 B의 합계)
    public int capacity() {
        return max;
    }

    // 스택에 쌓여있는 데이터 수를 반환
    public int size(AorB sw) {
        switch (sw) {
            case StackA:
                return ptrA;
            case StackB:
                return max - ptrB - 1;
        }
        return 0;
    }

    // 스택이 비어 있는가?
    public boolean isEmpty(AorB sw) {
        switch (sw) {
            case StackA:
                return ptrA <= 0;
            case StackB:
                return ptrB >= max - 1;
        }
        return true;
    }

    // 스택이 가득 찼는가?
    public boolean isFull() {
        return ptrA >= ptrB + 1;
    }

    // 스택 안의 터이터를 바닥 → 꼭대기의 차례로 나타냄
    public void dump(AorB sw) {
        switch (sw) {
            case StackA:
                if (ptrA <= 0)
                    System.out.println("스택이 비었습니다.");
                else {
                    for (int i = 0; i < ptrA; i++)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
                break;
            case StackB:
                if (ptrB >= max - 1)
                    System.out.println("스택이 비었습니다.");
                else {
                    for (int i = max - 1; i > ptrB; i--)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
                break;
        }
    }
}