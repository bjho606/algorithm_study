package BrouteForce_Easy;

import java.util.Scanner;

public class Q1065 {
    public static void main(String[] args){
        int count=0;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            String[] str=String.valueOf(i).split("");
            if(str.length<=2){
                ++count;
                continue;
            }
            ++count;
            int sub=Integer.parseInt(str[0])-Integer.parseInt(str[1]);
            for(int j=1;j<str.length-1;j++){
                if(Integer.parseInt(str[j])-Integer.parseInt(str[j+1])!=sub){
                    --count;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
