package BrouteForce_Easy;

import java.util.Scanner;

public class Q2231 {
    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        System.out.println(makers(n));
        for(int i=1;i<10001;i++){
            System.out.println(i+": "+makers(i));
        }
    }
    static int makers(int n){
//        if(n>=1&&n<10){
//            return 0;
//        }
        int i=1;
        while(true){
            if(i>n)
                return 0;
            if(i==n)
                return -1;
            int sum=i;
            int mod=i;
            while(true){
                sum+=(mod%10);
                mod=mod/10;
                if(mod==0)
                    break;
            }
            if(sum==n)
                break;
            ++i;
        }
        return i;
    }
}
