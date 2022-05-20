package BrouteForce_Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q1251 {
    static ArrayList<String> combination=new ArrayList<>();
    static String input;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        input=sc.nextLine();
        make_combination(1, 2, new int[2]);
        Collections.sort(combination);
        System.out.println(combination.get(0));
    }
    static void make_combination(int start, int r, int[] split_num){
        if(r==0){
            // 조합을 한뒤
            StringBuilder result=new StringBuilder();

            String sub=input.substring(0, split_num[0]);
            StringBuilder sb=new StringBuilder(sub);
            sb.reverse();
            result.append(sb);

            sub=input.substring(split_num[0],split_num[1]);
            sb=new StringBuilder(sub);
            sb.reverse();
            result.append(sb);

            sub=input.substring(split_num[1]);
            sb=new StringBuilder(sub);
            sb.reverse();
            result.append(sb);

            combination.add(result.toString());
            return;
        }
        for(int i=start;i<input.length()-r+1;i++){
            split_num[2-r]=i;
            make_combination(i+1, r-1, split_num);
        }
//        if(r==2){ // 첫번째 분할 지점을 찾을 때
//            for(int i=start;i<input.length()-2;i++){
//                split_num[r-2]=i;
//                make_combination(i+1, r-1, split_num);
//            }
//        }
//        else if(r==1){ // 두번째 분할 지점을 찾을 때
//            for(int i=start;i<input.length()-1;i++){
//                split_num[r-2]=i;
//                make_combination(i+1, r-1, split_num);
//            }
//        }

    }
}
