package D0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// permutation 사용, 비효율적
public class Q14888 {
    static int n;
    static long max_result=Long.MIN_VALUE;
    static long min_result=Long.MAX_VALUE;
    static ArrayList<String> list=new ArrayList<>();
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        numbers=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            numbers[i]=Integer.parseInt(st.nextToken());
        }
        String[] exp=br.readLine().split(" ");
        // 또 일일히...
        // 연산자 넣기 +
        for(int i=0;i<Integer.parseInt(exp[0]);i++){
            list.add("+");
        }
        // 연산자 넣기 -
        for(int i=0;i<Integer.parseInt(exp[1]);i++){
            list.add("-");
        }
        // 연산자 넣기 *
        for(int i=0;i<Integer.parseInt(exp[2]);i++){
            list.add("*");
        }
        // 연산자 넣기 /
        for(int i=0;i<Integer.parseInt(exp[3]);i++){
            list.add("/");
        }
        // 순서가 상관이 있다.
        perm_exp(new String[n-1], new boolean[list.size()],  0, list.size(), n-1);
        System.out.println(max_result+"\n"+min_result);
    }
    static void perm_exp(String[] output, boolean[] visit, int depth, int n, int r){
        if(depth==r){
            // 값을 계산하고 비교한다.
            calc(output);
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){
                visit[i]=true;
                output[depth]=list.get(i);
                perm_exp(output,  visit, depth+1, n, r);
                visit[i]=false;
            }
        }
    }
    // 값을 계산하고 비교한다.
    // 연산자의 순서가 output에 저장이 된다.
    // 그 순서대로 계산한 결과를 min, max인지 비교를 해서 넣는다.
    static void calc(String[] output){
        long result=numbers[0];
        for(int i=0;i<output.length;i++){
            if(output[i].equals("+")) result=result+numbers[i+1];
            else if(output[i].equals("-")) result=result-numbers[i+1];
            else if(output[i].equals("*")) result=result*numbers[i+1];
            else if(output[i].equals("/")) {
                if (result < 0) {// 음수일 경우
                    result = Math.abs(result);
                    result = (result / numbers[i + 1]) * -1;
                } else {
                    result = result / numbers[i + 1];
                }
            }
        }
        max_result=Math.max(max_result, result);
        min_result= Math.min(min_result, result);
    }
}
