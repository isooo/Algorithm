package ch09;

import java.util.Comparator;

public class Q01 {


}


class LinkedList<E> {
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


    // 생성자
    public LinkedList() {
        head = crnt = null;
    }

    // 노드 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;     // 현재 scan중인 노드

        while(ptr != null) {
            // 검색 성공
            if(c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;     // 다음 노드를 선택
        }
        return null;        // 검색 실패
    }

    // 머리에 노드 삽입
}
