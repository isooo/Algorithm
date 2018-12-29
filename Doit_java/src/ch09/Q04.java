package ch09;

import java.util.Comparator;

public class Q04 {
}

class AryLinkedList<E> {
    class Node<E> {
        private E data;     // 데이터
        private int next;   // 리스트의 뒤쪽 포인터
        private int dnext;  // free 리스트의 뒤쪽 포인터

        // data와 next 를 결정
        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] n;                    // 리스트 본체
    private int size;                       // 리스트의 용량 (가장 큰 데이터 수)
    private int max;                        // 사용 중인 꼬리 record
    private int head;                       // 머리 노드
    private int crnt;                       // 선택 노드
    private int deleted;                    // free 리스트의 머리 노드
    private static final int NULL = -1;     // 다음 노드 없음 / 리스트가 가득 참

    // 생성자
    public AryLinkedList(int capacity) {
        head = crnt = max = deleted = NULL;
        try {
            n = new Node[capacity];
            for(int i = 0 ; i < capacity ; i++) {
                n[i] = new Node<E>();
            }
            size = capacity;
        } catch(OutOfMemoryError e) {
            size = 0;       // 배열 생성 실패
        }
    }

    // 다음에 삽입하는 record의 인덱스를 구함
    private int getInsertIndex() {
        if(deleted == NULL) {           // 삭제할 record가 없음
            if(max < size) {
                return ++max;           // 새 record를 사용
            } else {
                return NULL;            // 용량 넘침
            }
        } else {
            int rec = deleted;          // free 리스트에서 머리 rec를 꺼냄
            deleted = n[rec].dnext;
            return rec;
        }
    }

    // record idx를 free리스트에 등록
    private void deleteIndex(int idx) {
        if(deleted == NULL) {           // 삭제할 record가 없음
            deleted = idx;              // idx를 free리스트와 머리에 등록
            n[idx].dnext = NULL;
        } else {
            int rec = deleted;          // idx를 free리스트의 머리에 삽입
            deleted = idx;
            n[rec].dnext = rec;
        }
    }

    public E search(E obj, Comparator<? super E> c) {
        int ptr = head;                     // 현재 스캔 중인 노드

        while(ptr != NULL) {
            if(c.compare(obj, n[ptr].data) == 0) {
                crnt = ptr;
                return n[ptr].data;         // 검색성공
            }
            ptr = n[ptr].next;              // 다음 노드에 주목
        }
        return null;                        // 검색실패
    }

    public void addFirst(E obj) {
        int ptr = head;                     // 삽입 전의 머리 노드
        int rec = getInsertIndex();
        if(rec != NULL) {
            head = crnt = rec;              // 인덱스 rec인 record에 삽입
            n[head].set(obj, ptr);
        }
    }

    public void addLast(E obj) {
        if(head == NULL) {
            addFirst(obj);
        } else {
            int ptr = head;
            while(n[ptr].next != NULL) {
                ptr = n[ptr].next;
            }
            int rec = getInsertIndex();
            if(rec != NULL) {               // 인덱스 rec인 record에 삽입
                n[ptr].next = crnt = rec;
                n[rec].set(obj, NULL);
            }
        }
    }
}
