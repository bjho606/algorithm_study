package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1204 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int test_case=Integer.parseInt(br.readLine());
            int[] score=new int[101];
            int[] students=new int[1000];
            StringTokenizer st=new StringTokenizer(br.readLine());
            // 점수에 해당하는 것은 ++해준다. count 0이면(학생수) student[학생수]=점수에 0으로 찍히겠지
            for(int j=0;j<1000;j++)
                ++score[Integer.parseInt(st.nextToken())];
            // count=점수
            for(int j=0;j<100;j++)
                students[score[j]]=j;
            for(int j=999;j>=0;j--){
                if(students[j]!=0){
                    System.out.println("#"+test_case+" "+students[j]);
                    break;
                }
            }
        }


    }
}
