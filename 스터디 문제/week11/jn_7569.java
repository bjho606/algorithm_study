package D0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7569 {
    static int m,n,h;
    // 6가지 방법
    static int[] mx={-1,1,0,0,0,0};
    static int[] my={0,0,1,-1,0,0};
    static int[] mz={0,0,0,0,1,-1};
    // 토마토 박스들
    static int[][][] box;
    static Queue<int[]> q=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());

        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    box[i][j][k]=Integer.parseInt(st.nextToken());
                    if(box[i][j][k]==1)
                        q.add(new int[]{i, j, k});
                }
            }
        }
        bfs();
    }
    static int bfs(){
        while(!q.isEmpty()){
            int[] t=q.poll();
            for(int i=0;i<6;i++){
                int nx=t[1]+mx[i];
                int ny=t[2]+my[i];
                int nz=t[0]+mz[i];

                // 범위와 방문?
                if(nx>=0&&ny>=0&&nz>=0&&nx<n&&ny<m&&nz<h){
                    if(box[nz][nx][ny]==0){
                        q.add(new int[]{nz, nx, ny});
                        box[nz][nx][ny]=box[t[0]][t[1]][t[2]]+1;
                    }
                }
            }
        }
        int result=Integer.MIN_VALUE;
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(box[i][j][k]==0)
                        return -1;
                    result=Math.max(result, box[i][j][k]);
                }
            }
        }
        if(result==1) return 0;
        else return result-1;
    }
}
