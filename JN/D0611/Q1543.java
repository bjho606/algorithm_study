package BrouteForce_Easy;

import java.util.Scanner;

public class Q1543 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int count=0;
        String str=sc.nextLine();
        String[] str_split=str.split("");
        String rex=sc.nextLine();
        String[] rex_split=rex.split("");
        for(int i=0;i< str_split.length;){
            if(rex_split[0].equals(str_split[i])){
                if(i+ rex_split.length> str_split.length){
                    ++i;
                    continue;
                }
                if(rex.equals(str.substring(i, i+rex.length()))){
                    count++;
                    i=i+rex.length();
                    continue;
                }
            }
            ++i;
        }
        System.out.println(count);
    }
}
