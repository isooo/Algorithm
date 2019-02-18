package Feb2019.COSPro2;

public class Ex09 {

    public String func_a(String str, int len){
        String padZero = "";
        int padSize = len - str.length();
        for(int i = 0; i < padSize; i++)
            padZero += "0";
        return padZero + str;
    }

    public int solution(String binaryA, String binaryB) {
        int maxLength = Math.max(binaryA.length(), binaryB.length());
        binaryA = func_a(binaryA, maxLength);
        binaryB = func_a(binaryB, maxLength);

        int hammingDistance = 0;
        for(int i = 0; i < maxLength; i++)
            if(binaryA.charAt(i) != binaryB.charAt(i))
                hammingDistance += 1;
        return hammingDistance;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Ex09 ex09 = new Ex09();
        String binaryA = "10010";
        String binaryB = "110";
        int ret = ex09.solution(binaryA, binaryB);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
