package BrouteForce_Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2422 {
    static int n, m, count=0;
    static List<Integer>[] not_ice;
    public static void main(String[] args) throws IOException {
        // 선택은 3개 가능, 먹으면 안되는 조합은 2쌍
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        not_ice=new List[n+1];
        for(int i=0;i<n+1;i++)
            not_ice[i]=new ArrayList<>();
        // 먹으면 안되는 조합 입력받기
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int index=Integer.parseInt(st.nextToken());
            int num=Integer.parseInt(st.nextToken());
            not_ice[Math.min(index, num)].add(Math.max(index, num));
        }
        // 아이스크림 3가지 선택
        ices_homo(new int[3], 0, 1);
        System.out.println(count);
    }
    static void ices_homo(int[] output, int r, int start){
        if(r==3){
            ++count;
            return;
        }
        for(int i=start;i<=n;i++){
            if(r>=1){
                if(!not_ice[output[0]].isEmpty()){
                    if(not_ice[output[0]].contains(i)){
                        continue;
                    }
                }
                if(r==2){
                    if(!not_ice[output[1]].isEmpty()){
                        if(not_ice[output[1]].contains(i)){
                            continue;
                        }
                    }
                }
            }
            output[r] = i;
            ices_homo(output, r + 1, i + 1);
        }
    }
}
