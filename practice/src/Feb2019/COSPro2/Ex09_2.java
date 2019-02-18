package Feb2019.COSPro2;

public class Ex09_2 {
    private String func_a(int length, String binaryStr) {
        String padStr = "";
        for(int i = 0 ; i < length - binaryStr.length() ; i++) {
            padStr += "0";
        }
        return padStr + binaryStr;
    }

    public int solution(String binaryA, String binaryB) {

        int length = Math.max(binaryA.length(), binaryB.length());

        String newBinaryA = func_a(length, binaryA);
        String newBinaryB = func_a(length, binaryB);

        int hammingDistance = 0;
        for(int i = 0 ; i < length ; i++) {
            if(newBinaryA.charAt(i) != newBinaryB.charAt(i)) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }


    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex09_2 ex09 = new Ex09_2();
        String binaryA = "10010";
        String binaryB = "110";
        int ret = ex09.solution(binaryA, binaryB);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
