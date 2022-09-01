package D0831;
import java.util.*;
import java.io.*;

// 빙산 DFS

public class Q2573 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int N, M, year =0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N =	Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int part = 1;
        while(true) {
            part = melting();
            if(part > 1) break;
            else if(part == -1) {
                year = 0;
                break;
            }
            meltedMapCheck();
            year++;
        }

        System.out.println(year);
    }

    private static void meltedMapCheck() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == -1) map[i][j] = 0;
            }
        }
    }

    private static int melting() {
        visited = new boolean[N][M];
        int part =0;
        for(int i=0; i< N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j] && map[i][j] > 0) {
                    part++;
                    if(part > 1) return part;
                    bfs(i, j);
                }
            }
        }
        if(part == 0) return -1;
        else return part;
    }

    private static void bfs(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {x, y});
        visited[x][y] = true;
        while(!deque.isEmpty()) {
            int[] pos = deque.poll();
            int px= pos[0];
            int py= pos[1];
            int zeroCnt =0;
            for(int i=0; i<4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                if(map[nx][ny] > 0) {
                    deque.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
                if(map[nx][ny] == 0) {
                    zeroCnt++;
                }
            }
            map[px][py] = map[px][py] - zeroCnt > 0? map[px][py] - zeroCnt : -1;
        }

    }
}
