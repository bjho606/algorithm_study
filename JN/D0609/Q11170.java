package BrouteForce_Easy;

import java.util.Scanner;

// 0의 개수
public class Q11170 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int count=0;
            for(int j=n;j<=m;j++){
                String[] s=String.valueOf(j).split("");
                for(int k=0;k<s.length;k++){
                    if(s[k].equals("0"))
                        ++count;
                }
            }
            System.out.println(count);
        }


    }
}
