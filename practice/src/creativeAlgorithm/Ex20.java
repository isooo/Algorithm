package creativeAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex20 {

    private static int operation(ArrayList<String> arr) {
        int result = Integer.parseInt(arr.get(0));
        for(int i=1; i<arr.size()-1; i+=2) {
            String op = arr.get(i);
            int tmp = Integer.parseInt(arr.get(i+1));
            if(op.equals("+")) {
                result += tmp;
            } else if(op.equals("-")) {
                result -= tmp;
            } else if(op.equals("/")) {
                result /= tmp;
            } else if(op.equals("*")) {
                result *= tmp;
            }
        }
        return result;
    }


    private static ArrayList<String> op(String str) {
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                arr.add(str.substring(0, i));
                arr.add(str.substring(i, i+1));
                str = str.substring(i+1);
                i = 0;
            }
        }
        arr.add(str);
        return arr;
    }


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str1 = br.readLine().replace(" ", "");
//        ArrayList<String> arr = op(str1);
//        int result = operation(arr);
//        System.out.println("result : " + result);

    }

}
