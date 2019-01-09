package ch11;

public class Q01_OpenHash {
    public static void main(String[] args) {

        OpenHash<Integer, String> oh = new OpenHash<>(10);
        oh.add(15, "십오");
        oh.add(2, "이");
        oh.add(25, "이십오");
        oh.add(7, "칠");
        oh.add(10, "십");
        oh.add(5, "오");

        oh.dump();
        System.out.println("===========================");

        oh.remove(25);
        oh.dump();
    }
}

class OpenHash<K, V> {
    enum Status {OCCUPIED, EMPTY, DELETED};     // 데이터 저장, 비어 있음, 삭제 마침

    static class Bucket<K, V> {
        private K key;              // 키
        private V data;             // 데이터
        private Status stat;        // 상태

        public Bucket() {
            stat = Status.EMPTY;        // 버킷은 비어 있음
        }

        // 모든 필드에 값을 설정
        void set(K key, V data, Status stat) {
            this.key = key;
            this.data = data;
            this.stat = stat;
        }

        // 상태를 설정
        void setStat(Status stat) {
            this.stat = stat;
        }

        // 키 값 반환
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
    private Bucket<K, V>[] table;       // 해시 테이블

    public OpenHash(int size) {
        try {
            table = new Bucket[size];
            for(int i = 0 ; i < size ; i++) {
                table[i] = new Bucket<K, V>();
            }
            this.size = size;
        } catch(OutOfMemoryError e) {
            this.size = 0;
        }
    }

    // 해시 값을 구함
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    // 재해시 값을 구함
    public int rehashValue(int hash) {
        return (hash + 1) % size;
    }

    // 키 값 key를 갖는 버킷의 검색
    private Bucket<K, V> searchNode(K key) {
        int hash = hashValue(key);          // 검색할 데이터의 해시 값
        Bucket<K, V> p = table[hash];       // 선택 버킷

        for(int i = 0 ; p.stat != Status.EMPTY && i < size ; i++) {
            if(p.stat == Status.OCCUPIED && p.getKey().equals(key)) {
                return p;
            }
            hash = rehashValue(hash);
            p = table[hash];
        }
        return null;
    }

    // 키 값 key를 갖는 요소의 검색(데이터를 반환)
    public V search(K key) {
        Bucket<K, V> p = searchNode(key);
        if(p != null) {
            return p.getValue();
        } else {
            return null;
        }
    }

    // 키 값 key, 데이터 data를 갖는 요소의 추가
    public int add(K key, V data) {
        if(search(key) != null) {
            return 1;                                   // 이미 등록된 키 값
        }

        int hash = hashValue(key);
        Bucket<K, V> p = table[hash];
        for(int i = 0 ; i < size ; i++) {
            if(p.stat == Status.EMPTY || p.stat == Status.DELETED) {
                p.set(key, data, Status.OCCUPIED);
                return 0;                               // 추가 완료
            }
            hash = rehashValue(hash);
            p = table[hash];        // 재해시
        }

        return 2;                                       // 해시 테이블이 가득 참
    }

    // 키 값 key를 갖는 요소의 삭제
    public int remove(K key) {
        Bucket<K, V> p = searchNode(key);
        if(p == null) {
            return 1;                                   // 이 키 값은 등록되지 않았음
        }

        p.setStat(Status.DELETED);
        return 0;
    }

    // 해시 테이블 덤프
    public void dump() {
        for(int i = 0 ; i < size ; i++) {
            System.out.printf("%02d ", i);
            switch (table[i].stat) {
                case OCCUPIED:
                    System.out.printf("%s  (%s)\n", table[i].getKey(), table[i].getValue());
                    break;
                case EMPTY:
                    System.out.println("-- 미등록 -- ");
                    break;
                case DELETED:
                    System.out.println("-- 삭제 마침 --");
                    break;
            }
        }
    }
}
