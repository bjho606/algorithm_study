package BrouteForce_Easy;

import java.util.Scanner;

public class Q2851 {
    public static void main(String[] args){
        int sum=0;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<10;i++){
            int n=sc.nextInt();
            int next=sum+n;
            if(next==100){
                sum=next;
                break;
            }
            else if(next>100){
                if(next-100<=100-sum)
                    sum=next;
                break;
            }
            sum=next;
        }
        System.out.println(sum);
    }
}
