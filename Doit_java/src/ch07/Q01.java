package ch07;

public class Q01 {
    public static void main(String[] args) {
        IntSet s1 = new IntSet(20);
        IntSet s2 = new IntSet(20);
        IntSet s3 = new IntSet(20);

        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);

        s1.copyTo(s2);
        s2.add(12);
        s2.remove(25);

        s3.copyFrom(s2);


    }
}

class IntSet {
    private int max;        // 집합의 최대 개수
    private int num;        // 집합의 요소 개수
    private int[] set;      // 집합 본체

    public IntSet(int capacity) {
        num = 0;
        max = capacity;
        try{
            set = new int[max];         // 집합 배열 생성
        } catch(OutOfMemoryError e) {   // 배열 생성 실패
            max = 0;
        }
    }

    // 집합의 최대 개수
    public int capacity() {
        return max;
    }

    // 집합의 요소 개수
    public int size() {
        return num;
    }

    // n 검색
    public int indexOf(int n) {
        for(int i = 0 ; i < num ; i++) {
            if(set[i] == n) {
                return i;
            }
        }
        return -1;      // 검색 실패시 -1 반환
    }

    // n 유무확인
    public boolean contains(int n) {
        return (indexOf(n) == -1) ? false : true;
    }

    // 집합에 n 추가
    public boolean add(int n) {
        if(num >= max || contains(n) == true) {
            return false;       // 집합이 가득 차있거나, 이미 n이라는 요소가 존재할 때
        } else {
            set[num++] = n;
            return true;
        }
    }

    // 집합에서 n 삭제
    public boolean remove(int n) {
        int idx;

        if(num <= 0 || (idx = indexOf(n)) == -1) {
            return false;
        } else {
            set[idx] = set[--num];      // 마지막 요소를 삭제한 idx로 옮긴다
            return true;
        }
    }

    // 집합 s에 복사
    public void copyTo(IntSet s) {
        int n = (s.max < num) ? s.max : num;

        for(int i = 0 ; i < n ; i++) {
            s.set[i] = set[i];
        }
        s.num = n;
    }

    // 집합 s를 복사
    public void copyFrom(IntSet s) {
        int n = (s.num < max) ? s.num : max;
        for(int i = 0 ; i < n ; i++) {
            set[i] = s.set[i];
        }
        num = n;
    }

    // 집합 s와 같은지 확인
    public boolean equalTo(IntSet s) {
        if(num != s.num) {      // 요소 개수 비교
            return false;
        }

        for(int i = 0 ; i < num ; i++) {
            int j = 0;
            for(;j < s.num ; j++) {
                if(set[i] == s.set[j]) break;
            }

            if(j == s.num) {
                return false;
            }
        }
        return true;
    }

    // 집합 s1과 s2의 합집합을 복사
    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1);
        for(int i = 0 ; i < s2.num ; i++) {
            add(s2.set[i]);
        }
    }

    // 공집합인지 확인
    public boolean isEmpty() {
        return num == 0;
    }

    // 집합이 가득 찼는지 확인
    public boolean isFull() {
        return num >= max;
    }

    // 집합을 초기화
    public void clear() {
        num = 0;
    }

    // 문자열로 print
    @Override
    public String toString() {
        StringBuffer bf = new StringBuffer("{ ");
        for(int i = 0 ; i < num ; i++) {
            bf.append(set[i] + " ");
        }
        bf.append("}");
        return bf.toString();
    }
}