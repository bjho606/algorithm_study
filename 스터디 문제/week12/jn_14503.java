package D0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로봇 청소기, 닦
public class Q14503 {
    static int N,M,r,c,d, ans;
    static int [][] map;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        map = new int [N][M];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // 시작 위치
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()); // 시작 방향
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isClean(r,c,d);
        System.out.println(ans); // 청소하는 칸 갯수

    }

    public static void isClean(int x, int y, int dir) {
        if(map[x][y]==0) { // 청소할 것
            map[x][y]=2;
            ans++;
        }
        boolean flag = false;
        int direction = dir; // 로봇 청소기 방향

        for(int i=0;i<4;i++) {
            //북서남동으로 회전
            int nd = (dir+3)%4; // 방향 구하기!
            int nx = x+dx[nd]; // 방향대로 가기
            int ny = y+dy[nd]; // 방향대로 가기
            if(range(nx,ny)) { // 맵 범위 맞다면
                if(map[nx][ny]==0) { // 왼쪽방향에 청소할 공간 존재
                    isClean(nx,ny,nd); // 청소하기
                    flag = true; // 청소 했다.
                    break;
                }
            }
            dir = nd;
        }

        //여기에 왔다면 후진만 가능, 청소가 되어있거나벽
        if(!flag) {
            // 처음 위치에서 뒤로 한칸
            int nd = (direction+2) %4;
            int nx = x+dx[nd];
            int ny = y+dy[nd];
            if(range(nx,ny) && map[nx][ny]!=1) { // 조건 체크
                isClean(nx,ny,direction); //바라보는 방향 유지하면서 후진
            }
        }
    }

    public static boolean range(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}
