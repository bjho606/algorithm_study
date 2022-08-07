package D0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean [][] arr;
    static int N,start,end,M;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        arr = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        ans = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y]=true;
            arr[y][x]=true;
        }
        bfs(start,end);

        if(ans[end]==0) {
            System.out.println(-1);
        }else {
            System.out.println(ans[end]);
        }
    }
    private static void bfs(int start,int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            if(temp == end) break;

            for (int i = 1; i <= N; i++) {
                if(arr[temp][i] && !visited[i]) {
                    q.add(i);
                    visited[i]=true;
                    ans[i]=ans[temp]+1;
                }
            }
        }
    }
}