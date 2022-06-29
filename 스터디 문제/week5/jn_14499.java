package D0629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비효율적으로 짠 코드!
public class Q14499 {
    static int[][] dice=new int[4][3];
    static int[][] map;
    static int[] dice_pos;
    static int n, m, k;
    static int we=4000, ns=4000;
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]); // 맵의 가로축
        m=Integer.parseInt(input[1]); // 맵의 세로축
        int x=Integer.parseInt(input[2]); // 주사위의 처음 위치 세로쭈루룩
        int y=Integer.parseInt(input[3]); // 주사위의 처음 위치 가로쭈루룩
        k=Integer.parseInt(input[4]); // 명령어 갯수
        map=new int[n][m]; // 지도 생성
        dice_pos=new int[]{x, y}; // 주사위의 위치
        for(int i=0;i<n;i++){ // 지도의 값 입력받기
            String[] row=br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(row[j]);
            }
        }
        // command 입력받기
        String[] command=br.readLine().split(" ");
        for(int i=0;i<k;i++){
            int move_command=Integer.parseInt(command[i]);
            int after=map_pos_chk(move_command); // 주사위를 이동시킨다.
            if(after==-1) // 범위 밖으로 넘어갔음으로
                continue;
            update_dice(move_command); // 주사위의 상태를 바꿔준다.
            // 이동
            if(map[dice_pos[0]][dice_pos[1]] == 0){ // 지도 상에서 이동한 곳의 value 가 0이면, 주사위의 바닥면의 수>지도의 칸 value
                map[dice_pos[0]][dice_pos[1]]=dice[3][1];
            }
            else{ // 지도 상에서 이동한 곳의 value 가 0이 아니라면, 지도의 칸 value>주사위 바닥면, 지도의 칸=0
                dice[3][1]=map[dice_pos[0]][dice_pos[1]];
                map[dice_pos[0]][dice_pos[1]]=0;
            }
            System.out.println(dice[1][1]);
        }
    }
    // 맵에서 주사위의 위치를 검사하는 용도
    static int map_pos_chk(int command){
        // -1이면 넘어가기
        int result=0;
        if(command==1){ // 동 +, 두번째
            // 주사위가 맵 밖으로 나가는지 검사
            if(dice_pos[1]+1>=m)
                result=-1;
            else{
                dice_pos[1]+=1;
            }
        }
        else if(command==2){ // 서 -, 두번째
            // 주사위가 맵 밖으로 나가는지 검사
            if(dice_pos[1]-1<0)
                result=-1;
            else
                dice_pos[1]-=1;
        }
        else if(command==3){ // 북 -, 첫번째
            // 주사위가 맵 밖으로 나가는지 검사
            if(dice_pos[0]-1<0)
                result=-1;
            else
                dice_pos[0]-=1;
        }
        else if(command==4){ // 남 +, 첫번째
            // 주사위가 맵 밖으로 나가는지 검사
            if(dice_pos[0]+1>=n)
                result=-1;
            else
                dice_pos[0]+=1;
        }
        return result;
    }
    static void update_dice(int command){
        if(command==1){ // 동
            int temp=dice[1][0];
            dice[1][0]=dice[3][1];
            dice[3][1]=dice[1][2];
            dice[1][2]=dice[1][1];
            dice[1][1]=temp;
        }
        else if(command==2){ // 서
            int temp=dice[3][1];
            dice[3][1]=dice[1][0];
            dice[1][0]=dice[1][1];
            dice[1][1]=dice[1][2];
            dice[1][2]=temp;
        }
        else if(command==3){ // 북
            int temp=dice[3][1];
            dice[3][1]=dice[0][1];
            dice[0][1]=dice[1][1];
            dice[1][1]=dice[2][1];
            dice[2][1]=temp;
        }
        else if(command==4){ // 남
            int temp=dice[0][1];
            dice[0][1]=dice[3][1];
            dice[3][1]=dice[2][1];
            dice[2][1]=dice[1][1];
            dice[1][1]=temp;
        }
    }
}
