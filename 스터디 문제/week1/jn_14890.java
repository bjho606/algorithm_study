package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14890 {
    static int n, l;
    static int map[][];
    public static void main(String[] args)throws IOException {
        // 입력 받기
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        map=new int[n][n];
        int not_map_count=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                map[i][j]=Integer.parseInt(st.nextToken());
        }
        // 총 2n개의 길을 보게 된다.
        // 1. 행씩 보기
        int j;
        for(int i=0;i<n;i++){
            int[] col=map[i];
            System.out.println(Arrays.toString(col));
            int is_same=1;
            boolean low=false;
            for(j=1;j<n;j++){
                if(col[j-1]==col[j]) { // 전 값과 동일하다.
                    ++is_same;
                    if(low){
                        if(j==n-1&&is_same<l){
                            ++not_map_count;
                            break;
                        }
                        else if(is_same==l){
                            is_same=0;
                            low=false;
                        }
                        else if(is_same>l){
                            is_same=1;
                            low=false;
                        }
                    }
                }
                else if(col[j-1]<col[j]){ // 앞으로의 값이 더 크다.
                    if(col[j]-col[j-1]!=1){ // 높이 차가 1이 아니면 끝
                        not_map_count++;
                        break;
                    }
                    if(is_same<l){ // 경사로를 놓기 위해, 연속된 낮은 칸의 갯수가 l 미만이면 끝
                        not_map_count++;
                        break;
                    }
                    is_same=1;
                }
                else{ // 전의 값이 더 크다.
                    if(col[j-1]-col[j]!=1){ // 높이 차가 1이 아니면 끝
                        not_map_count++;
                        break;
                    }
                    if(l==1){
                        is_same=0;
                        continue;
                    }
                    if(low&&is_same<l){ // 값이 낮은 버전으로 바뀌는 경우
                        not_map_count++;
                        break;
                    }
                    if(is_same<l&&j==n-1){
                        not_map_count++;
                        break;
                    }
                    if(j==n-1&&l!=1){
                        not_map_count++;
                        break;
                    }
                    is_same=1;
                    low=true;
                }
            }
        }
        // 2. 열 보기
        for(int i=0;i<n;i++){
            int[] row=new int[n];
            for(int k=0;k<n;k++)
                row[k]=map[k][i];
            System.out.println("row_map: "+Arrays.toString(row));
            int is_same=1;
            boolean low=false;
            for(j=1;j<n;j++){
                if(row[j-1]==row[j]) { // 전 값과 동일하다.
                    ++is_same;
                    if(low){
                        if(j==n-1&&is_same<l){
                            ++not_map_count;
                            break;
                        }
                        else if(is_same==l){
                            is_same=0;
                            low=false;
                        }
                        else if(is_same>l){
                            is_same=1;
                            low=false;
                        }
                    }
                }
                else if(row[j-1]<row[j]){ // 앞으로의 값이 더 크다.
                    if(row[j]-row[j-1]!=1){ // 높이 차가 1이 아니면 끝
                        not_map_count++;
                        break;
                    }
                    if(is_same<l){ // 경사로를 놓기 위해, 연속된 낮은 칸의 갯수가 l 미만이면 끝
                        not_map_count++;
                        break;
                    }
                    is_same=1;
                }
                else{ // 전의 값이 더 크다.
                    if(row[j-1]-row[j]!=1){ // 높이 차가 1이 아니면 끝
                        not_map_count++;
                        break;
                    }
                    if(l==1){
                        is_same=0;
                        continue;
                    }
                    if(low&&is_same<l){ // 값이 낮은 버전으로 바뀌는 경우
                        not_map_count++;
                        break;
                    }
                    if(is_same<l&&j==n-1){
                        not_map_count++;
                        break;
                    }
                    if(j==n-1&&l!=1){
                        not_map_count++;
                        break;
                    }
                    is_same=1;
                    low=true;
                }
            }
        }
        System.out.println("is map: "+(2*n-not_map_count));
    }

}
