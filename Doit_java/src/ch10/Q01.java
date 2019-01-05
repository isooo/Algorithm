package ch10;

import java.util.Comparator;

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

        // 키 값을 반환
        K getKey() {
            return key;
        }

        // 데이터를 반환
        V getValue() {
            return data;
        }

        // 데이터를 출력
        void print() {
            System.out.println("data : " + data);
        }

    }

    private Node<K, V> root;                            // 루트
    private Comparator<? super K> comparator = null;    // 비교자

    // 생성자
    public BinTree() {
        this.root = null;       // 루트에 대한 참조인 root를 null로 하여, 노드가 하나도 없는(비어있는) 이진검색트리를 생성하는 생성자
    }

    public BinTree(Comparator<? super K> c) {
        this();                 // 비어있는 이진검색트리를 생성
        this.comparator = c;
    }

    // 두 키 값을 비교
    private int comp(K key1, K key2) {
        // key1이 크면 양수, 동일하면 0
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    // 키에 의한 검색
    public V search(K key) {
        Node<K, V> p = root;                            // 루트에 주목

        while(true) {
            if(p == null) {
                return null;
            }
            int cond = comp(key, p.getKey());           // key와 노드 p의 키를 비교
            if(cond == 0) {
                return p.getValue();                    // 검색 성공
            } else if(cond < 0) {
                p = p.left;                             // 왼쪽 서브 트리에서 검색
            } else {
                p = p.right;                            // 오른쪽 서브 트리에서 검색
            }
        }
    }

    // node를 루트로 하는 서브 트리에 노드<K, V> 를 삽입
    private void addNode(Node<K, V> node, K key, V data) {
        int cond = comp(key, node.getKey());

        if(cond == 0) {
            return;
        } else if(cond < 0) {
            if(node.left == null) {
                node.left = new Node<K, V>(key, data, null, null);
            } else {
                addNode(node.left, key, data);          // 왼쪽 서브트리에 주목
            }
        } else {
            if(node.right == null) {
                node.right = new Node<K, V>(key, data, null, null);
            } else {
                addNode(node.right, key, data);
            }
        }
    }

    // 노드를 삽입
    public void add(K key, V data) {
        if(root == null) {
            root = new Node<K, V>(key, data, null, null);
        } else {
            addNode(root, key, data);
        }
    }
}

