package ch10;

import java.util.Comparator;

public class Q01 {
    public static void main(String[] args) {

        BinTree<Integer, String> bin = new BinTree<>();

        bin.add(1, "일");
        bin.add(2, "이");
        bin.add(8, "팔");
        bin.add(6, "육");
        bin.add(3, "삼");
        bin.add(5, "오");
        bin.add(7, "칠");
        bin.add(4, "사");

        bin.print();
        System.out.println("=================================");
        bin.printReverse();
    }
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

    // 키 값이 key인 노드를 삭제
    public boolean remove(K key) {
        Node<K, V> p = root;                    // 스캔 중인 노드
        Node<K, V> parent = null;               // 스캔 중인 노드의 부모 노드
        boolean isLeftChild = true;             // p는 부모의 왼쪽 자식 노드인가?

        while(true) {
            if(p == null) {                     // 더 이상 진행하지 않으면
                return false;                   // 그 키 값은 없습니다
            }

            int compResult = comp(key, p.getKey());     // key와 노드 p의 키 값을 비교
            if(compResult == 0) {
                break;                                  // 검색 성공
            } else {
                parent = p;
                if(compResult < 0) {                    // key가 작고, 스캔 중인 노드가 크면
                    isLeftChild = true;                 // 왼쪽 자식으로 내려감
                    p = p.left;
                } else {
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }

        if(p.left == null) {                    // p에는 왼쪽 자식이 없음
            if(p == root) {
                root = p.right;
            } else if(isLeftChild) {
                parent.left = p.right;          // p가 부모의 왼쪽 자식일 경우, 부모의 왼쪽 포인터가 p의 오른쪽 자식을 가리킴
            } else {
                parent.right = p.right;         // 부모의 오른쪽 포인터가, p의 오른쪽 자식을 가리킴 (== p가 삭제됨)
            }
        } else if(p.right == null) {
            if(p == root) {
                root = p.left;
            } else if(isLeftChild) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        } else {
            parent = p;
            Node<K, V> left = p.left;           // 왼쪽 서브트리 가운데 가장 큰 노드
            isLeftChild = true;
            while(left.right != null) {         // p의 왼쪽 서브트리 가운데 가장 큰 노드를 찾음
                parent = left;
                left = left.right;
                isLeftChild = false;
            }

            p.key = left.key;                   // left의 key값을 p로 옮김
            p.data = left.data;                 // left의 데이터를 p로 옮김

            if(isLeftChild) {
                parent.left = left.left;
            } else {
                parent.right = left.left;
            }
        }
        return true;
    }

    // target을 루트로 하는 서브 트리의 노드를 키 값의 오름차순으로 출력
    private void printSubTree(Node target) {
        if(target != null) {
            printSubTree(target.left);          // 왼쪽 서브 트리를 키 값의 오름차순으로 출력
            System.out.println(target.key + " : " + target.data);
            printSubTree(target.right);         // 오른쪽 서브 트리를 키 값의 오름차순으로 출력
        }
    }

    // 모든 노드를 키 값의 오름차순으로 출력
    public void print() {
        printSubTree(root);
    }

    // 모든 노드를 키 값의 내림차순으로 출력하기
    public void printReverse() {
        printSubTreeR(root);
    }

    // target을 루트로 하는 서브 트리의 노드를, 키 값의 내림차순으로 출력
    private void printSubTreeR(Node target) {
        if(target != null) {
            printSubTreeR(target.right);
            System.out.println(target.key + " : " + target.data);
            printSubTreeR(target.left);
        }
    }

    // 가작 작은 키 값을 갖는 노드를 반환
    private Node<K, V> getMinNode() {
        if(root == null) {
            return null;
        } else {
            Node<K, V> p = root;
            while(p.left != null) {
                p = p.left;
            }
            return p;
        }
    }

    // 가장 큰 키 값을 갖는 노드를 반환
    private Node<K, V> getMaxNode() {
        if(root == null) {
            return null;
        } else {
            Node<K, V> p = root;
            while(p.right != null) {
                p = p.right;
            }
            return p;
        }
    }

    // 가장 작은 키 값을 반환
    public K getMinKey() {
        Node<K, V> p = getMinNode();
        return (p == null ? null : p.getKey());
    }

    // 가장 작은 키 값을 갖는 노드의 데이터를 반환
    public V getDataWithMinKey() {
        Node<K, V> p = getMinNode();
        return (p == null ? null : p.getValue());
    }

    // 가장 큰 키 값을 반환
    public K getMaxKey() {
        Node<K, V> p = getMaxNode();
        return (p == null ? null : p.getKey());
    }

    // 가장 큰 키 값을 갖는 노드의 데이터를 반환
    public V getDataWithMaxKey() {
        Node<K, V> p = getMaxNode();
        return (p == null ? null : p.getValue());
    }
}

