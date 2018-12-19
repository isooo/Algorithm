package ch07;

public class Q05 {
    public static void main(String[] args) {

        IntSortedSet s1 = new IntSortedSet(7);
        IntSortedSet s2 = new IntSortedSet(5);
        s1.add(1);
        s1.add(32);
        s1.add(3);
        s1.add(46);
        s1.add(20);
        s1.add(7);
        s1.add(89);
        s2.copyFrom(s1);
        s2.remove(7);
        s2.add(10);

        System.out.println("s1 :: " + s1);
        System.out.println("s2 :: " + s2);

        IntSortedSet s3 = new IntSortedSet(10);
        s3.intersectionOf(s1, s2);
        System.out.println("s3 : " + s3);
        IntSortedSet s4 = new IntSortedSet(10);
        s4.differenceOf(s1, s2);
        System.out.println("s4 : " + s4);
    }
}

class IntSortedSet {
    private int max;        // 집합의 최대 개수
    private int num;        // 집합의 요소 개수
    private int[] set;      // 집합 본체

    public IntSortedSet(int capacity) {
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
        int pl = 0;
        int pr = num - 1;
        while(pl <= pr) {
           int pc = (pl + pr) / 2;
           if(set[pc] == n) {
               return pc;
           } else if(set[pc] < n) {
               pl = pc + 1;
           } else {
               pr = pc - 1;
           }
        }
        return -pl - 1;      // pl 에 -1 (pl이 0 일수도 있으므로) 한 뒤 음수로 만들어주어 리턴
    }

    // n 유무확인
    public boolean contains(int n) {
        return (indexOf(n) >= 0) ? true : false;
    }

    // 집합에 n 추가 : 이진탐색으로 n보다 작은 수를 찾아내어 그 인덱스까지 재배열.
    public boolean add(int n) {
        int idx;
        if(num >= max || (idx = indexOf(n)) >= 0) {
            return false;       // 집합이 가득 차있거나, 이미 n이라는 요소가 존재할 때
        } else {
            idx = -(idx + 1);
            num++;
            for(int i = num - 1 ; i > idx ; i--) {
                set[i] = set[i - 1];
            }
            set[idx] = n;
            return true;
        }
    }

    // 집합에서 n 삭제
    public boolean remove(int n) {
        int idx;
        if(num <= 0 || (idx = indexOf(n)) < 0) {
            return false;
        } else {
            num--;
            for(int i = idx ; i < num ; i++ ) {
                set[i] = set[i + 1];
            }
            return true;
        }
    }

    // 집합 s에 복사
    public void copyTo(IntSortedSet s) {
        int n = (s.max < num) ? s.max : num;

        for(int i = 0 ; i < n ; i++) {
            s.set[i] = set[i];
        }
        s.num = n;
    }

    // 집합 s를 복사
    public void copyFrom(IntSortedSet s) {
        int n = (s.num < max) ? s.num : max;
        for(int i = 0 ; i < n ; i++) {
            set[i] = s.set[i];
        }
        num = n;
    }

    // 집합 s와 같은지 확인
    public boolean equalTo(IntSortedSet s) {
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
    public void unionOf(IntSortedSet s1, IntSortedSet s2) {
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

    // s와 교집합 만들기
    public boolean retain(IntSortedSet s) {
        boolean flag = false;
        for(int i = 0 ; i < num ; i++) {
            if(s.contains(set[i]) == false) {
                remove(set[i]);
                flag = true;
            }
        }
        return flag;
    }

    // s와 차집합 만들기
    public boolean remove(IntSortedSet s) {
        boolean flag = false;
        for(int i = 0 ; i < num ; i++) {
            if(s.contains(set[i]) == true) {
                remove(set[i]);
                flag = true;
            }
        }
        return flag;
    }

    // s의 부분집합인지 확인
     public boolean isSubsetOf(IntSortedSet s) {
        if(num <= s.num) {
            for(int i = 0 ; i < num ; i++) {
                int j = 0;
                for(; j < s.num ; j++) {
                    if(s.set[j] == set[i]) {
                       break;
                    }
                }
                if(j == s.num) {
                    return false;
                }
            }
            return true;
        }
        return false;
     }

    // s의 진부분집합인지 확인
     public boolean isProperSubsetOf(IntSortedSet s) {
        boolean flag = false;
        if(num < s.num) {
            flag = isSubsetOf(s);
        }
        return flag;
     }

     // s1과 s2의 교집합을 복사
    public void intersectionOf(IntSortedSet s1, IntSortedSet s2) {
        clear();
        for(int i = 0 ; i < s1.num ; i++) {
            if(s2.contains(s1.set[i])) {
                add(s1.set[i]);
            }
        }
    }

    // s1과 s2의 차집합을 복사
    public void differenceOf(IntSortedSet s1, IntSortedSet s2) {
        clear();
        for(int i = 0 ; i < s1.num ; i++) {
            if(!s2.contains(s1.set[i])) {
                add(s1.set[i]);
            }
        }
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