package Feb2019.COSPro2;

public class Ex10_2 {

    public int findOp(String str) {
        for(int i = 0 ; i < str.length() ; i++) {
            char e = str.charAt(i);
            if(e == '+' || e == '-' || e == '*') {
                return i;
            }
        }
        return -1;
    }

    public int operation(int first, int second, String str, int opIdx) {
        if(str.charAt(opIdx) == '+') {
            return first + second;
        } else if(str.charAt(opIdx) == '-') {
            return first - second;
        } else {
            return first * second;
        }
    }

    public int solution(String expression) {
        int opInx = findOp(expression);
        int first = Integer.parseInt(expression.substring(0, opInx));
        int second = Integer.parseInt(expression.substring(opInx + 1));
        int result = operation(first, second, expression, opInx);
        return result;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex10_2 ex10 = new Ex10_2();
        String expression = "123423*112";
//        String expression = "123+12";
        int ret = ex10.solution(expression);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
