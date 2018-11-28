package ch04;

import java.util.Scanner;

public class Q01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack intStack = new IntStack(64); // 최대 64개를 푸시할 수 있는 스택

        while(true) {
            System.out.println(">> 현재 데이터 수 : " + intStack.size() + " / " + intStack.capacity());
            System.out.print(">> (1)푸시  (2)팝  (3)피크  (4)덤프  (5)검색  (6)비움  (7)정보표시 (0)종료 ： ");
            int num = sc.nextInt();

            if(num == 0) break;

            int x;
            switch (num) {
                case 1:
                    System.out.print("삽입할 데이터 : ");
                    x = sc.nextInt();
                    try {
                        intStack.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = intStack.pop();
                        System.out.println(x + "가 제거되었습니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비었습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = intStack.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비었습니다.");
                    }
                    break;

                case 4:
                    try {
                        intStack.dump();
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비었습니다.");
                    }
                    break;

                case 5:
                    System.out.print("검색할 데이터 : ");
                    x = sc.nextInt();
                    try {
                        int result = intStack.indexOf(x);
                        if(result <= 0) {
                            System.out.println("데이터가 존재하지 않습니다.");
                        } else {
                            System.out.println(x + "는 꼭대기로부터 " + (intStack.size() - result) + "에 있습니다.");
                        }
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비었습니다.");
                    }
                    break;

                case 6:
                    intStack.clear();
                    break;

                case 7:
                    System.out.println("용량：" + intStack.capacity());
                    System.out.println("데이터 수：" + intStack.size());
                    System.out.println("비어 " + (intStack.isEmpty() ? "있습니다." : "있지 않습니다."));
                    System.out.println("가득 " + (intStack.isFull() ? "찼습니다." : "차지 않았습니다."));
                    break;

            }
        }
    }

}

class IntStack {
    private int max;
    private int ptr;
    private int[] stk;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    public IntStack(int capacity) {
        this.ptr = 0;
        this.max = capacity;
        try{
            stk = new int[max];
        } catch(OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if(ptr >= max) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if(ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr];
    }

    public int peek() throws EmptyIntStackException {
        if(ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[ptr - 1];
    }

    // 요소의 인덱스 찾기(가장 먼저 pop될 수 있는 요소부터 검색)
    public int indexOf(int x) {
        for(int i = ptr - 1 ; i >= 0 ; i--) {
            if(stk[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // 스택을 비움
    public void clear() {
        ptr = 0;
    }

    public int capacity() {
        return max;
    }

    // 스택에 쌓여있는 데이터 수를 반환
    public int size() {
        return ptr;
    }

    // 스택이 비어있는가
    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    // 스택 안에 있는 모든 데이터를 표시하는 메서드
    public void dump() {
        if(isEmpty()) {
            System.out.println("스택이 비어있습니다.");
        } else {
            for(int i = 0 ; i < ptr ; i++) {
                System.out.print(stk[i] + "  ");
            }
            System.out.println();
        }
    }
}