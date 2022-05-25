
package BrouteForce_Easy;

import java.util.Scanner;

public class Q2966 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        /** 0 **/
        char[] A = {'A', 'B', 'C'};
        char[] B = {'B', 'A', 'B', 'C'};
        char[] G = {'C', 'C', 'A', 'A', 'B', 'B'};
        boolean flag = true;
        String[] name = {"Adrian", "Bruno", "Goran"};
        int[] rightCount = new int[3];
        String answer = scan.next();

        /** 1 **/
        for(int i=0; i<answer.length(); i++) {
            for(int j=0; j<A.length; j++) {
                if(i+j >= answer.length()) {
                    flag = false;
                    break;
                }

                if(answer.charAt(i+j) == A[j])
                    rightCount[0] ++;
            }
            if(!flag)
                break;
            i += A.length-1;
        }

        /** 2 **/
        flag = true;
        for(int i=0; i<answer.length(); i++) {
            for(int j=0; j<B.length; j++) {
                if(i+j >= answer.length()) {
                    flag = false;
                    break;
                }

                if(answer.charAt(i+j) == B[j])
                    rightCount[1] ++;
            }
            if(!flag)
                break;
            i += B.length-1;
        }

        /** 3 **/
        flag = true;
        for(int i=0; i<answer.length(); i++) {
            for(int j=0; j<G.length; j++) {
                if(i+j >= answer.length()) {
                    flag = false;
                    break;
                }

                if(answer.charAt(i+j) == G[j])
                    rightCount[2] ++;
            }
            if(!flag)
                break;
            i += G.length-1;
        }

        /** 4 **/
        int max = 0;
        for(int i=0; i<rightCount.length; i++)
            if(rightCount[i] > max)
                max = rightCount[i];
        System.out.println(max);

        /** 5 **/
        for(int i=0; i<name.length; i++) {
            if(max == rightCount[i])
                System.out.println(name[i]);
        }

        scan.close();
    }

}