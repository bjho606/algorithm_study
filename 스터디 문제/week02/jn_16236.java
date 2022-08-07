package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 아기상어가 물고기를 잡아먹을 수 있는 시간 출력
public class Q16236 {
    // 아기상어 위치: 9, 빈칸: 0, 123456: 물고기 크기
    static int[] m_x={-1, 1, 0, 0};
    static int[] m_y={0, 0, -1, 1};
    static ArrayList<BabyShark> fish;
    static int[][] map;
    static int count, shark_size=2, time, sx, sy;
    public static void main(String[] args)throws IOException {
        // 입력받기
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int num=Integer.parseInt(st.nextToken());
                if(num==9){
                    sx=i;
                    sy=j;
                    num=0;
                }
                map[i][j]=num;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(map[i][j]+" ");
            System.out.println();
        }
        // bfs

        while(true){
            fish=new ArrayList<>();
            Queue<BabyShark> q=new LinkedList<>();
            q.offer(new BabyShark(sx, sy, 0));
            boolean[][] visit=new boolean[n][n];
            visit[sx][sy]=true;
            while(!q.isEmpty()){
                BabyShark old_pos=q.poll();
                for(int i=0;i<4;i++){
                    int now_x=old_pos.x+m_x[i];
                    int now_y=old_pos.y+m_y[i];
                    if(now_x>=0&&now_x<n&&now_y>=0&&now_y<n&&!visit[now_x][now_y]){
                        // 먹이 냠냠 & 이동
                        if(map[now_x][now_y]>=1&&map[now_x][now_y]<shark_size){
                            fish.add(new BabyShark(now_x, now_y, old_pos.dist+1));
                            q.offer(new BabyShark(now_x, now_y, old_pos.dist+1));
                            visit[now_x][now_y]=true;
                        }
                        // 이동
                        else if(map[now_x][now_y]==shark_size||map[now_x][now_y]==0){
                            q.offer(new BabyShark(now_x, now_y, old_pos.dist+1));
                            visit[now_x][now_y]=true;
                        }

                    }
                }
            }
            if(fish.size()==0){
                System.out.println(time);
                return;
            }
            BabyShark b=fish.get(0);
            for(int i=1;i<fish.size();i++){
                if(fish.get(i).dist<b.dist){
                    b=fish.get(i);
                }
                if(b.dist==fish.get(i).dist){
                    if(b.x>fish.get(i).x){
                        b=fish.get(i);
                    }
                }
            }
            time+=b.dist;
            count++;
            map[b.x][b.y]=0;
            if(count==shark_size){
                shark_size++;
                count=0;
            }
            sx=b.x;
            sy=b.y;
        }
    }
    static class BabyShark{
        int x, y, dist;
        public BabyShark(int x, int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
}

