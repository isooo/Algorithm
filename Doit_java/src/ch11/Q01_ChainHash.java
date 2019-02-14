package ch11;

public class Q01_ChainHash {
    public static void main(String[] args) {

        ChainHash<Integer, String> ch = new ChainHash<>(10);
        ch.add(10, "십");
        ch.add(45, "사십오");
        ch.add(3, "삼");
        ch.add(27, "이십칠");
        ch.add(9, "구");
        ch.add(15, "십오");
        ch.add(61, "육십일");
        ch.add(35, "삼십오");
        ch.add(77, "칠십칠");
        ch.add(87, "팔십칠");

        ch.dump();

    }
}

class ChainHash<K, V> {
    class Node<K, V> {
        private K key;              // 키 값
        private V data;             // 데이터
        private Node<K, V> next;    // 다음 노드에 대한 참조

        public Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        // 키 값을 반환
        K getKey() {
            return key;
        }

        // 데이터를 반환
        V getValue() {
            return data;
        }

        // 키의 해시 값을 반환
        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size;                   // 해시 테이블의 크기
    private Node<K, V>[] table;         // 해시 테이블

    public ChainHash(int size) {
        try {
            table = new Node[size];
            this.size = size;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    // 해시 값을 구함
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    // 키 값 key를 갖는 요소의 검색 (데이터를 반환)
    public V search(K key) {
        int hash = hashValue(key);          // 검색할 데이터의 해시 값
        Node<K, V> p = table[hash];         // 선택 노드

        while (p != null) {
            if (p.getKey().equals(key)) {
                return p.getValue();
            }
            p = p.next;
        }
        return null;
    }

    // 키 값 key, 데이터 data를 갖는 요소의 추가
    public int add(K key, V data) {
        int hash = hashValue(key);          // 추가할 데이터의 해시 값
        Node<K, V> p = table[hash];         // 선택 노드

        while (p != null) {
            if (p.getKey().equals(key)) {
                return 1;
            }
            p = p.next;
        }

        Node<K, V> tmp = new Node<>(key, data, table[hash]);
        table[hash] = tmp;
        return 0;
    }

    // 키 값 key를 갖는 요소의 삭제
    public int remove(K key) {
        int hash = hashValue(key);          // 삭제할 데이터의 해시 값
        Node<K, V> p = table[hash];         // 선택 노드
        Node<K, V> pp = null;               // 바로 앞의 선택 노드

        while (p != null) {
            if (p.getKey().equals(key)) {
                if (pp == null) {
                    table[hash] = p.next;
                } else {
                    pp.next = p.next;
                }
            }
            pp = p;
            p = p.next;
        }
        return 1;
    }

    // 해시 테이블 덤프
    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K, V> p = table[i];
            System.out.printf("%02d   ", i);
            while (p != null) {
                System.out.printf("-> %s (%s)   ", p.getKey(), p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }
}
