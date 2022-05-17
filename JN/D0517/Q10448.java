package BrouteForce_Easy;

import java.util.Scanner;

public class Q10448 {
    static int[] t_arr=new int[51];
    static int n, correct;
    public static void main(String[] args){
        for(int i=1;i<=50;i++)
            t_arr[i]=(i*(i+1))/2;
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            n=sc.nextInt();
            correct=0;
            int[] answer=new int[3];
            System.out.println("===="+n+"====");
            homo_combination(answer, 1, 3);
            System.out.println(correct);
        }
    }
    static void homo_combination(int[] output, int start, int r){
        if(r==0){
            int sum=0;
            for(int i=0;i<3;i++){
                sum+=output[i];
            }
            if(sum==n){
                correct=1;
                for(int i=0;i<3;i++){
                    System.out.print(output[i]+" ");
                }
                System.out.println();
            }
            return;
        }
        for(int i=start;i<=50;i++){
            output[r-1]=t_arr[i];
            homo_combination(output, i, r-1);
        }
    }
}
