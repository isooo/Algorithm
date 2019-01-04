package ch10;

public class Q01 {
}

class BinTree<K, V> {
    // 노드
    static class Node<K, V> {
        private K key;              // 키 값
        private V data;             // 데이터
        private Node<K, V> left;    // 왼쪽 자식 노드
        private Node<K, V> right;   // 오른쪽 자식 노드

        // 생성자
        Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}

