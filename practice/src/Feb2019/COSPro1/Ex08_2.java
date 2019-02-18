package Feb2019.COSPro1;

public class Ex08_2 {
    boolean solution(String sentence){
        String str = sentence.replace(" ", "").replace(".", "");
        for(int i = 0 ; i < str.length() / 2 ; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다. main 메소드는 잘못된 부분이 없으니, solution 메소드만 수정하세요.
    public static void main(String[] args) {
        Ex08_2 ex08_2 = new Ex08_2();
        String sentence1 = "never odd or even.";
        boolean ret1 = ex08_2.solution(sentence1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");


        String sentence2 = "palindrome";
        boolean ret2 = ex08_2.solution(sentence2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2+ " 입니다.");
    }
}
