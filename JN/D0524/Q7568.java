package BrouteForce_Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q7568 {
    static ArrayList<Bulk> input=new ArrayList<>();
    static int[] level;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        level=new int[n];
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            input.add(new Bulk(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(input, (o1, o2) -> {
            if(o1.weight == o2.weight){
                if(o1.height > o2.height)
                    return 1;
                else if(o1.height < o2.height)
                    return -1;
                else
                    return 0;
            }
            else if(o1.weight>o2.weight)
                return 1;
            else
                return -1;

        });
//        for(Bulk b:input){
//            System.out.println("Height: "+b.height+"cm, Weight: "+b.weight+"kg");
//        }
        for(int i=0;i<n;i++){
            Bulk me=input.get(i);
            int count=0;
            for(int j=i+1;j<n;j++){
                if(me.weight<input.get(j).weight && me.height<input.get(j).height)
                    ++count;
            }
            level[me.num]=count+1;
        }
        for(int i=0;i<n;i++){
            System.out.print(level[i]+" ");
        }

    }
    public static class Bulk{
        int num;
        int weight;
        int height;
        public Bulk(int num, int i, int j){
            this.num=num;
            weight=i;
            height=j;
        }
    }
}
