package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 원판을 T번 회전시킨 후, 원판에 적힌 수의 합 출력
public class Q17822 {
    static int n, m, t;
    static int[][] circle;
    static int[] mx={-1, 1, 0, 0};
    static int[] my={0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        // 입력 저장
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());
        circle=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++)
                circle[i][j]=Integer.parseInt(st.nextToken());
        }
        // 정해진 순서대로 회전
        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            rotate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) );
            if(!remove())
                replace();
        }
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(circle[i][j]!=-1){
                    result+=circle[i][j];
                }
            }
        }
        System.out.println(result);

    }
    static void rotate(int x, int d, int kk){
        for(int i=0;i<n;i++){
            if((i+1)%x!=0){
                continue;
            }
            // 시계방향
            if(d==0){
                for(int j=0;j<kk;j++){
                    int[] tmp=circle[i].clone();
                    circle[i][0]=tmp[m-1];
                    for(int k=1;k<m;k++){
                        circle[i][k]=tmp[k-1];
                    }
                }
            }
            // 반시계 방향
            else{
                for(int j=0;j<kk;j++){
                    int[] tmp=circle[i].clone();
                    circle[i][m-1]=tmp[0];
                    for(int k=0;k<m-1;k++){
                        circle[i][k]=tmp[k-1];
                    }
                }
            }
        }

    }
    static void replace(){
        int sum=0, count=0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (circle[i][j] != -1) {
                    sum += circle[i][j];
                    count++;
                }
            }
        }
        // 평균값 구할 때 실수 주의!!!!!!!!
        double avg = sum / (double) count;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle[i][j] != -1) {
                    // 평균보다 크면 빼고
                    if ((double) circle[i][j] > avg)
                        circle[i][j]-=1;
                    // 평균보다 작으면 더하기
                    else if ((double) circle[i][j] < avg)
                        circle[i][j]+=1;
                }
            }
        }

    }
    static boolean remove(){
        boolean result=false;
        boolean[][] visit=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(circle[i][j]==-1||visit[i][j])
                    continue;
                Queue<int[]> q=new LinkedList<>();
                q.add(new int[]{i, j, circle[i][j]});
                visit[i][j]=true;
                // bfs........
                while(!q.isEmpty()){
                    int[] now_pos=q.poll();
                    for(int k=0;k<4;k++){
                        int n_x=now_pos[0]+mx[k];
                        int n_y=now_pos[1]+my[k];

                        if (n_x<0 || n_x>= n)
                            continue;
                        if (n_y == -1)
                            n_y= m-1;
                        else if (n_y == m)
                            n_y=0;
                        if (visit[n_x][n_y])
                            continue;
                        if (circle[n_x][n_y] == now_pos[2]) {
                            visit[n_x][n_y]=true;
                            q.add(new int[] { n_x, n_y, now_pos[2] });
                            circle[now_pos[0]][now_pos[1]] = -1;
                            circle[n_x][n_y] = -1;
                            result=true;
                        }
                    }
                }
            }
        }
        return result;
    }
}
