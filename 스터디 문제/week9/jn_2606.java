package D0803;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int[][] graph;
    static boolean[] visit;
    static int count=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m=sc.nextInt();
        graph=new int[n+1][n+1];
        visit=new boolean[n+1];
        for(int i=0;i<m;i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph[a][b]=1;
            graph[b][a]=1;
        }
        bfs(1);
    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visit[start]=true;
        queue.offer(start);
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int i=1;i<visit.length;i++) {
                if(graph[x][i]==1 && !visit[i]) {
                    queue.offer(i);
                    visit[i]=true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}