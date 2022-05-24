package BrouteForce_Easy;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2635 {
    static int result_size=Integer.MIN_VALUE;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); // 30,000 이하의 수
//        ArrayList<Integer> list;
//        ArrayList<Integer> result=new ArrayList<>();
        StringBuilder list;
        StringBuilder result=new StringBuilder();
        for(int i=n;i>=0;i--) {
            int prev_prev=n;
            int prev=i;
            int count=2;
            list=new StringBuilder();
            list.append(prev_prev+" "+prev+" ");
            while(true){
                int num=prev_prev-prev;
                if(num<0){
                    break;
                }
                else{
                    list.append(num+" ");
                    prev_prev=prev;
                    prev=num;
                    ++count;
                }
            }
            // 비교
            if(result_size<=count){
                result_size=count;
                result=new StringBuilder(list);
            }
        }
        System.out.println(result_size);
        System.out.println(result);
    }
}
