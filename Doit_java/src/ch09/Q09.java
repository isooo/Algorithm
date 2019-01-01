package ch09;

import java.util.Comparator;

public class Q09 {
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



}
