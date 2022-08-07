package D0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q15683 {
    static int n, m, blank;
    static int[][] map;
    static ArrayList<cctvInfo> cctv_pos=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        // 입력받기
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int idx=Integer.parseInt(st.nextToken());
                if(idx>=1&&idx<=5){ // cctv 라면 위치를 추가해준다.
                    cctv_pos.add(new cctvInfo(idx, i, j));
                }
                else if(idx==0) // 총 빈 공간을 구한다.
                    ++blank;
                map[i][j]=idx;
            }
        }
        // 큰 cctv 부터 지워나가기
        Collections.sort(cctv_pos);
        // Arraylist cctv 목록 처음부터 지워나간다.
        for(int i=0;i< cctv_pos.size();i++){
            erase(cctv_pos.get(i));
        }
        // 남은 공간을 카운트해서 빈공간에다가 빼준다.

    }
    static void erase(cctvInfo c){
        // 방향을 바꿀 필요가 없음으로 먼저 처리
        if(c.num==5){
            // 세로 방향
            for(int i=c.x+1;i<n;i++){
                if(map[i][c.y]==6)
                    break;
                map[i][c.y]=-1;
            }
            for(int i=c.x-1;i>=0;i--){
                if(map[i][c.y]==6)
                    break;
                map[i][c.y]=-1;
            }
            // 가로 방향
            for(int i=c.y+1;i<m;i++){
                if(map[c.x][i]==6)
                    break;
                map[c.x][i]=-1;
            }
            for(int i=c.y-1;i>=0;i--){
                if(map[c.x][i]==6)
                    break;
                map[c.x][i]=-1;
            }
        }
        else{
            // 최대로 지울 수 있는 위치들을 맵에 적용시킨다.
            ArrayList<int[]> list=get_max(c);
            for(int i=0;i<list.size();i++) {
                map[list.get(i)[0]][list.get(i)[1]] = -1;
            }
        }

    }
    // 최대로 지울 수 있는 CCTV domain position 으로 구하기
    static ArrayList<int[]> get_max(cctvInfo c){
        ArrayList<int[]> list=new ArrayList<>();
        if(c.num==1){// 4가지 경우의 수
            // ->
            for(int i=)
            // <-
            // up
            // down

        }
        else if(c.num==2){// 2가지 경우의 수

        }
        else if(c.num==3){// 3가지 경우의 수

        }
        else{

        }
        return list;
    }
    static void left(){


        // 가로 방향
        for(int i=c.y+1;i<m;i++){
            if(map[c.x][i]==6)
                break;
            map[c.x][i]=-1;
        }

    }
    static void right(){
        for(int i=c.x+1;i<n;i++){
            if(map[i][c.y]==6)
                break;
            map[i][c.y]=-1;
        }
    }
    static void up(){
        for(int i=c.x-1;i>=0;i--){
            if(map[i][c.y]==6)
                break;
            map[i][c.y]=-1;
        }
    }
    static void down(){
        for(int i=c.x+1;i<n;i++){
            if(map[i][c.y]==6)
                break;
            map[i][c.y]=-1;
        }
        for(int i=c.y-1;i>=0;i--){
            if(map[c.x][i]==6)
                break;
            map[c.x][i]=-1;
        }
    }
}
class cctvInfo implements Comparable<cctvInfo> {
    int num;
    int x, y;
    public cctvInfo(int n, int x, int y){
        this.num=n;
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(cctvInfo o) {
        if(o.num>this.num)
            return 1;
        else if(o.num==this.num)
            return 0;
        else
            return -1;
    }
}
