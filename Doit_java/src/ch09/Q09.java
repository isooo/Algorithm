package ch09;

import java.util.Comparator;

public class Q09 {

    public static void main(String[] args) {
        DbLinkedList<String> str = new DbLinkedList<>();
        str.addFirst("첫번째");
        str.addLast("두번째");
        str.addLast("카피");
        str.addLast("세번째");
        str.addLast("카피2");
        str.addLast("네번째");
        str.addLast("카피");
        str.addLast("카피2");
        str.addLast("카피");
        str.addLast("다섯번째");
        str.addLast("카피2");
        str.addLast("카피2");
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

class DbLinkedList<E> {

    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            prev = next = this;
        }

        Node(E obj, Node<E> prev, Node<E> next) {
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public DbLinkedList() {
        head = crnt = new Node<E>();
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head.next;

        while(ptr != head) {
            if(c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    // 선택 노드를 출력
    public void printCurrentNode() {
        if(isEmpty()) {
            System.out.println("선택 노드가 없습니다.");
        } else {
            System.out.println("선택 노드 : " + crnt.data);
        }
    }

    // 모든 노드를 출력
    public void dump() {
        Node<E> ptr = head.next;

        while(ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    // 모든 노드를 거꾸로 출력
    public void dumpReverse() {
        Node<E> ptr = head.prev;

        while(ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if(isEmpty() | crnt.next == head) {
            return false;       // 이동할 수 없음
        }
        crnt = crnt.next;
        return true;
    }

    // 선택 노드를 하나 앞쪽으로 이동
    public boolean prev() {
        if(isEmpty() | crnt.prev == head) {
            return false;       // 이동할 수 없음
        }
        crnt = crnt.prev;
        return true;
    }

    // 선택 노드 바로 뒤에 노드를 삽입
    public void add(E obj) {
        Node<E> node = new Node<>(obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    // 머리에 노드 삽입
    public void addFirst(E obj) {
        crnt = head;
        add(obj);
    }

    // 꼬리에 노드 삽입
    public void addLast(E obj) {
        crnt = head.prev;
        add(obj);
    }

    // 선택 노드를 삭제
    public void removeCurrentNode() {
        if(!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if(crnt == head) {
                crnt = head.next;
            }
        }
    }

    // 노드 p 를 삭제
    public void remove(Node p) {
        Node<E> ptr = head.next;

        while(ptr != head) {
            if(ptr == p) {
                crnt = p;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }

    // 머리 노드를 샥제
    public void removeFirst() {
        crnt = head.next;
        removeCurrentNode();
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        crnt = head.prev;
        removeCurrentNode();
    }

    // 모든 노드를 삭제
    public void clear() {
        while(isEmpty()) {
            removeFirst();
        }
    }

    // 동일한 노드를 찾은 후, 가장 앞쪽 노드만 남기고 모두 삭제
    public void purge(Comparator<? super E> c) {
        Node<E> ptr = head.next;

        while(ptr.next != head) {
            Node<E> ptr2 = ptr;
            Node<E> pre = ptr;

            while(pre.next != head) {
                ptr2 = pre.next;
                if(c.compare(ptr.data, ptr2.data) == 0) {
                    pre.next = ptr2.next;
                } else {
                    pre = ptr2;
                }
            }

            ptr = ptr.next;
        }
        crnt = head;
    }

    // 머리부터 n개 뒤의 노드에 대한 참조
    public E retrieve(int n) {
        Node<E> ptr = head.next;

        while(n >= 0 && ptr.next != head) {
            if(n-- == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }
}
