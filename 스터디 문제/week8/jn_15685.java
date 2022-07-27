package BrouteForce_Easy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Q15685 {

    static boolean visit[][];
    static int dr[] = {0,-1,0,1};
    static int dc[] = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.valueOf(st.nextToken());
        visit = new boolean[101][101];
        for(int i=0; i<N;i ++) {
            st = new StringTokenizer(in.readLine(), " ");
            int c=Integer.valueOf(st.nextToken());
            int r=Integer.valueOf(st.nextToken());
            int d=Integer.valueOf(st.nextToken());
            int g=Integer.valueOf(st.nextToken());
            visit[r][c]=true;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(d);
            for(int j=1; j<=g; j++) {
                for(int k=list.size()-1; k>=0; k--) {
                    int nd = (list.get(k)+2)%4;
                    nd-=1;
                    nd = nd==-1 ? 3:nd;
                    list.add(nd);
                }
            }
            move(r,c,list);
        }
        int ans = check();
        System.out.println(ans);
    }
    static void move(int r, int c, ArrayList<Integer> list) {
        for(int k : list) {
            r = r+dr[k];
            c = c+dc[k];
            visit[r][c] = true;
        }
    }
    static int check() {
        int ans=0;
        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                if(i+1>100 || j+1>100) continue;
                if(visit[i][j] && visit[i+1][j+1] &&
                        visit[i+1][j] && visit[i][j+1]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
