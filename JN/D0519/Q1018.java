package BrouteForce_Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {
    static String[][] board;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        board=new String[n][m];
        for(int i=0;i<n;i++){
            board[i]=br.readLine().split("");
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i+8<=n;i++){
            for(int j=0;j+8<=m;j++){
                result=Math.min(result, chk_modify(i, j));
            }
        }
        System.out.println(result);
    }
    static int chk_modify(int n, int m){
        // 횐색으로 시작, 검정색으로 시작한 것 두개를 비교해서 작은 값을 출력
        int w_modify=0;
        int b_modify=0;
        // 1. 횐색으로 시작
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(i%2==0&&j%2==0&&!board[i+n][j+m].equals("W"))
                    ++w_modify;
                else if(i%2==1&&j%2==1&&!board[i+n][j+m].equals("W"))
                    ++w_modify;
                else if(i%2==0&&j%2==1&&!board[i+n][j+m].equals("B"))
                    ++w_modify;
                else if(i%2==1&&j%2==0&&!board[i+n][j+m].equals("B"))
                    ++w_modify;
            }
        }
        // 2. 검정색으로 시작
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(i%2==0&&j%2==0&&!board[i+n][j+m].equals("B"))
                    ++b_modify;
                else if(i%2==1&&j%2==1&&!board[i+n][j+m].equals("B"))
                    ++b_modify;
                else if(i%2==0&&j%2==1&&!board[i+n][j+m].equals("W"))
                    ++b_modify;
                else if(i%2==1&&j%2==0&&!board[i+n][j+m].equals("W"))
                    ++b_modify;
            }
        }
        //System.out.println("start_white: "+w_modify+". start_black: "+b_modify);
        return Math.min(w_modify, b_modify);
    }
}
