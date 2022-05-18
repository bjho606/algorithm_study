import java.util.Scanner;

public class Q14697 {
    static int[] arr=new int[3];
    static int count=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        arr[0]=sc.nextInt();
        arr[1]=sc.nextInt();
        arr[2]=sc.nextInt();
        int sum=sc.nextInt();
        h_combination(0, sum);
        System.out.println(count);
    }
    static void h_combination(int start, int sum){
        if(sum==0){
            count=1;
            return;
        }
        else if(sum<0)
            return;
        for(int i=start;i<3;i++){
            sum=sum-arr[i];
            h_combination(i, sum);
        }

    }
}
