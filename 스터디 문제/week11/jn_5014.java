package D0820;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5014 {
    static int f, s, g, u, d;
    static int[] btn=new int[1000000+1];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        f=sc.nextInt(); // floor
        s=sc.nextInt(); // start
        g=sc.nextInt(); // end
        u=sc.nextInt(); // up
        d=sc.nextInt(); // down

        bfs();
    }
    static void bfs(){
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        btn[s]=1;
        while(!q.isEmpty()){
            int c=q.poll();
            if(c==g){
                System.out.println(btn[c]-1);
                return;
            }
            // up
            if((c+u<=f) && (btn[c+u]==0)){
                btn[c+u]=btn[c]+1;
                q.add(c+u);
            }
            // down
            if((c-d>0) &&(btn[c-d]==0)){
                btn[c-d]=btn[c]+1;
                q.add(c-d);
            }
        }
        System.out.println("use the stairs");
        return;
    }
}
