package ch09;

import java.util.Comparator;

public class Q03 {

    public static void main(String[] args) {
        LinkedListT<String> str = new LinkedListT<>();
        str.addFirst("첫번째");
        str.addLast("두번째");
        str.addLast("카피");
        str.addLast("세번째");
        str.addLast("네번째");
        str.addLast("카피");
        str.addLast("카피");
        str.addLast("다섯번째");
        str.addLast("카피");
        str.addLast("여섯번째");
        str.addLast("카피");
        str.addLast("카피");
        str.addLast("마지막");
        str.addLast("카피");

        str.dump();
        System.out.println("==============================================");

        str.purge(String::compareTo);

        str.dump();
        System.out.println("==============================================");

        str.removeCurrentNode();
        str.dump();

    }

}


class LinkedListT<E> {
    class Node<E> {
        private E data;
        private Node<E> next;   // 뒤쪽포인터

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }


    private Node<E> head;   // 머리노드
    private Node<E> crnt;   // 선택노드
    private Node<E> tail;   // 꼬리노드


    // 생성자
    public LinkedListT() {
        head = crnt = tail = null;
    }

    // 노드 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;     // 현재 scan중인 노드

        while (ptr != null) {
            // 검색 성공
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;     // 다음 노드를 선택
        }
        return null;        // 검색 실패
    }

    // 머리에 노드 삽입
    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
        if (tail == null) {
            tail = crnt;
        }
    }

    // 꼬리에 노드 삽입
    public void addLast(E obj) {
        if (head == null) {      // 리스트가 비어있으면
            addFirst(obj);      // 머리에 삽입
        } else {
            tail.next = crnt = new Node<E>(obj, null);
            tail = crnt;
        }
    }

    // 머리 노드를 삭제
    public void removeFirst() {
        if (head != null) {
            head = crnt = head.next;
            if (head == null) {
                tail = null;
            }
        }
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        if (head != null) {
            if (head.next == null) {     // 노드가 하나만 있으면
                removeFirst();          // 머리 노드를 삭제
            } else {
                Node<E> ptr = head;     // 스캔 중인 노드
                Node<E> pre = head;     // 스캔 중인 노드의 앞쪽 노드

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;        // pre는 삭제 후의 꼬리 노드
                tail = crnt = pre;
            }
        }
    }

    // 노드 삭제
    public void remove(Node target) {
        if (head != null) {
            if (target == head) {
                removeFirst();
            } else if (target == tail) {
                removeLast();
            } else {
                Node<E> ptr = head;

                while (ptr.next != target) {
                    ptr = ptr.next;
                    if (ptr == null) {
                        return;         // target이 리스트에 없는 경우
                    }
                }
                ptr.next = target.next;
                crnt = ptr;
            }
        }
    }

    // 현재 선택된 노드 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드를 삭제
    public void clear() {
        while (head != null) {
            removeFirst();      // 노드에 아무것도 없을 때까지 머리 노드를 삭제
        }
        crnt = null;
    }

    // 선택 노드 crnt를 하나 뒤로 이동
    public boolean next() {
        if (crnt == null || crnt.next == null) {
            return false;
        }
        crnt = crnt.next;
        return true;
    }

    // 선택 노드 crnt를 출력
    public void printCurrentNode() {
        if (crnt == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.println("선택된 노드 : " + crnt.data);
        }
    }

    // 모든 노드를 출력
    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println("\t" + ptr.data);
            ptr = ptr.next;
        }
    }


    // 동일한 노드를 찾아, 가장 앞쪽 노드만 남기고 나머진 삭제하기
    public void purge(Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            int cnt = 0;
            Node<E> ptr2 = ptr;
            Node<E> pre = ptr;
            Node<E> tmp = null;

            while (pre.next != null) {
                ptr2 = pre.next;
                if (c.compare(ptr.data, ptr2.data) == 0) {
                    pre.next = ptr2.next;
                    tmp = ptr2;
                    cnt++;
                } else {
                    pre = ptr2;
                }
            }

            if (cnt == 0) {
                ptr = ptr.next;
            } else if (tmp != null) {
                Node<E> tmp2 = ptr;
                ptr = tmp2.next;
            }
        }
        crnt = head;
    }

    // 머리부터 n개 뒤의 노드에 대한 참조
    public E retrieve(int n) {

        Node<E> ptr = head;
        while (n >= 0 && ptr != null) {
            if (n-- == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }
}
