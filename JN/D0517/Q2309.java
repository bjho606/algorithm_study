package BrouteForce_Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q2309 {
    static int arr[]=new int[9];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<9;i++)
            arr[i]=sc.nextInt();
        boolean[] visit=new boolean[9];
        combination(visit, 0, 7);
    }
    static void combination(boolean[] visit, int start, int r){
        if(r==0){
            chk(visit);
            return;
        }
        for(int i=start;i<9;i++){
            visit[i]=true;
            combination(visit, i+1, r-1);
            visit[i]=false;
        }
    }
    static void chk(boolean[] visit){
        // 합이 100이 된다면 System.exit(0) 정상 종료,
        int sum=0;
        ArrayList<Integer> answer=new ArrayList<>();
        for(int i=0;i<9;i++){
            if(visit[i]){
                sum+=arr[i];
                answer.add(arr[i]);
            }
        }
        if(sum==100){
            Collections.sort(answer);
            for(Integer i:answer)
                System.out.println(i);
            System.exit(0);
        }
    }
}
