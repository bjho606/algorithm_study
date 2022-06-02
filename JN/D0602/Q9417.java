package BrouteForce_Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9417 {
    static int max_result;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            max_result=Integer.MIN_VALUE;
            String[] arr=br.readLine().split(" ");
            int[] int_arr=new int[arr.length];
            for(int j=0;j<arr.length;j++){
                int_arr[j]=Integer.parseInt(arr[j]);
            }
            hm(int_arr, new int[2], 0, 0);
            System.out.println(max_result);
        }

    }
    static void hm(int[] input, int[] result, int r, int start){
        if(r==2){// 두개를 다 선택했으면, 최대공약수를 구한다.
            max_result=Math.max(max_result, gcd(result[0], result[1]));
            return;
        }
        for(int i=start;i<input.length;i++){
            result[r]=input[i];
            hm(input, result, r+1, i+1);
        }
    }
    // 최대 공약수 구하기
    static int gcd(int a, int b){
        int x=Math.max(a, b);
        int y=Math.min(a, b);
        while(true){
            int temp=y;
            y=x%y;
            if(y==0){
                return temp;
            }
            x=temp;
        }

    }
}
