package D0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 비효율적인 코드
// 특히 H_member에서  중복이 된다.
public class Q14889 {
    static int min_result=Integer.MAX_VALUE;
    static int[][] input_level;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        input_level=new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                input_level[i][j]=Integer.parseInt(st.nextToken());
        }
        int[] human=new int[n+1];
        for(int i=1;i<=n;i++)
            human[i]=i;
        H_member(human, new boolean[n+1], 1,n, n/2);
        System.out.println(min_result);
    }
    static void H_member(int[] arr, boolean[] visit, int start, int n, int r){
        if(r==0){
            // 선택된것은 true, 아닌 것은 false로 팀을 나누기!
            get_result(visit);
            return;
        }
        for(int i=start;i<=n;i++){
            visit[i]=true;
            H_member(arr, visit, i+1, n, r-1);
            visit[i]=false;
        }
    }
    static void get_result(boolean[] visit){
        ArrayList<Integer> start_team=new ArrayList<>();
        ArrayList<Integer> link_team=new ArrayList<>();

        int start_level=0, link_level=0;

        for(int i=1;i<visit.length;i++){
            if(visit[i]) start_team.add(i);
            else link_team.add(i);
        }
        for(Integer i:start_team){
            for(Integer j:start_team)
                start_level+=input_level[i-1][j-1];
        }
        for(Integer i:link_team) {
            for (Integer j : link_team)
                link_level += input_level[i-1][j-1];
        }

        min_result=Math.min(min_result, Math.abs(link_level-start_level));
    }
}
