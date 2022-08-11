import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int result=Integer.MIN_VALUE;
    static int[][] map;
    static int[] mx={-1, 0, 1, 0};
    static int[] my={0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        int max_height=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int num=Integer.parseInt(st.nextToken());
                map[i][j]=num;
                max_height=Math.max(num, max_height);
            }
        }
        for(int i=0;i<=max_height;i++) // i 이하는 잠긴다.
        {
            // 새로운 맵 만들기, false로 채워짐..ㅜ?
            boolean[][] visit=new boolean[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(map[j][k]<=i) // 높이가 i 이하라면 잠김으로 visit=true(방문했다 치고)
                        visit[j][k]=true;
                }
            }
            // bfs 통해서 섬의 갯수 세기
            bfs(visit);
        }
        System.out.println(result);
    }
    static void bfs(boolean[][] visit){
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    // 방문한 곳이면 빠이
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] old=q.poll();
                        for(int k=0;k<4;k++){
                            int nx=old[0]+mx[k];
                            int ny=old[1]+my[k];
                            // 범위 맞고, visit=false면 queue에 넣는다. 그리고 true 처리
                            if(nx>=0&&nx<n&&ny>=0&&ny<n&&!visit[nx][ny]) {
                                q.add(new int[]{nx, ny});
                                visit[nx][ny] = true;
                            }
                        }
                    }
                    ++count;
                }
            }
        }
        result=Math.max(count, result);

    }
}
