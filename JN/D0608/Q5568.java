package BrouteForce_Easy;

import java.util.*;

public class Q5568 {
    static int[] input;
    static int choice, n;
    static HashMap<Integer, Integer> hashMap=new HashMap<>();
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        choice=sc.nextInt();

        input=new int[n];
        for(int i=0;i<n;i++)
            input[i]=sc.nextInt();
        h_make_num(new StringBuilder(), 0, new boolean[n]);
        System.out.println(hashMap.size());
    }
    static void h_make_num(StringBuilder sb, int r, boolean[] visit){
        if(r==choice){
            hashMap.put(Integer.parseInt(sb.toString()),hashMap.getOrDefault(Integer.parseInt(sb.toString()),0)+1);
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){ //방문을 한곳이 아니라면
                visit[i]=true;
                h_make_num(new StringBuilder(sb.toString()+input[i]),r+1, visit);
                visit[i]=false;
            }

        }

    }
}
